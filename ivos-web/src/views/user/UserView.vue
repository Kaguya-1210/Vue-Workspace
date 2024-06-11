<!--用户管理页-->

<template>
  <div style="height: 6vh;background-color: #fff;padding: 10px 20px">
    <span style="font-size: 20px;line-height: 60px">用户管理</span>
    <el-button @click="dialogVisible=true" type="primary" style="float: right; margin-top: 10px">新建用户</el-button>
  </div>

    <!-- 新建/编辑用户弹窗 -->
<!--    before-close="handleClose"确认是否关闭窗口-->
    <el-dialog :title="dialogTitle" v-model="dialogVisible"
               :before-close="handleClose"
               style="width: 1000px;padding: 40px">

      <el-form label-position="top" label-width="80px">


        <el-row :gutter="30">


          <el-col :span="12">

            <el-form-item label="用户名">

              <el-input placeholder="请输入用户名" v-model="saveUserFrom.username"></el-input>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="手机号">

              <el-input placeholder="请输入手机号" v-model="saveUserFrom.phone"></el-input>

            </el-form-item>

          </el-col>
        </el-row>

        <el-row :gutter="30">


          <el-col :span="12">

            <el-form-item label="邮箱">

              <el-input placeholder="请输入邮箱" v-model="saveUserFrom.email"></el-input>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="年龄">

              <el-input placeholder="请输入年龄" v-model="saveUserFrom.age"></el-input>

            </el-form-item>

          </el-col>


        </el-row>


        <el-row :gutter="30">


          <el-col :span="6">
            <el-form-item label="职级">
              <el-select placeholder="请选择" v-model="saveUserFrom.level">
                <el-option v-for="item in levelOptions"
                           :label="item.label" :value="item.value"></el-option>
              </el-select>
            </el-form-item>
          </el-col>


          <el-col :span="6">
            <el-form-item label="直属领导">
              <el-select placeholder="请选择" v-model="saveUserFrom.parentId">
                <el-option v-for="item in leaderOptions" :label="item.username" :value="item.id"></el-option>
              </el-select>
            </el-form-item>
          </el-col>


          <el-col :span="4">
            <el-form-item label="性别">
              <el-radio-group v-model="saveUserFrom.gender">
                <el-radio label="男" border value="1" style="margin: 0;"></el-radio>
                <el-radio label="女" border value="0"></el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>


          <el-col :span="6">
            <el-form-item label="用户状态">
              <el-radio-group v-model="saveUserFrom.status">
                <el-radio label="启用" border value="1" style="margin: 0;"></el-radio>
                <el-radio label="禁用" border value="0"></el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>


        </el-row>
      </el-form>

      <template #footer>
        <el-button @click="handleClose">取消</el-button>
        <el-button type="primary" @click="saveUser" >保存</el-button>
      </template>


    </el-dialog>



  <el-card style="margin: 20px;height: 70px">

    <el-form :inline="true">

      <el-form-item label="用户搜索">
        <el-input placeholder="请输入用户名" style="width: 220px" v-model="searchUserFrom.username"></el-input>
      </el-form-item>

      <el-form-item label="用户状态">

        <el-select placeholder="请选择用户状态" style="width: 290px" v-model="searchUserFrom.status">
          <el-option label="启用" value="1"></el-option>
          <el-option label="禁用" value="0"></el-option>
        </el-select>

      </el-form-item>

      <el-form-item>
        <el-button>重置</el-button>
        <el-button type="primary" @click="loadUser">查询</el-button>
      </el-form-item>
    </el-form>

  </el-card>


<!--  用户信息表-->
  <el-card style="margin: 20px">

    <el-table :data="userArr">

      <el-table-column type="index" label="编号" width="80" align="center"></el-table-column>
      <el-table-column prop="username" label="用户名" align="center"></el-table-column>
      <el-table-column prop="phone" label="手机号" align="center"></el-table-column>
      <el-table-column prop="createTime" label="加入时间" align="center"></el-table-column>
      <el-table-column prop="status" label="用户状态" align="center">
        <template #default="scope">
          <el-switch active-value="1" in inactive-value="0" v-model="scope.row.status"></el-switch>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button type="primary" size="small" link>密码重置</el-button>
          <el-button type="primary" size="small" link>编辑</el-button>
          <el-button type="primary" size="small" link>删除</el-button>

        </template>


      </el-table-column>

    </el-table>

  </el-card>


</template>

<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import qs from "qs";

// 控制弹窗出现;
const dialogVisible = ref(false);
// 保存弹窗标题;
const dialogTitle = ref('新建用户');

// 定义数组保存员工职级
const levelOptions = ref([
      {label: '职员', value: '10'},
      {label: '经理', value: '20'},
      {label: '总监', value: '30'},
      {label: '总裁', value: '40'}
    ]
)

// 定义数组直接保存直属领导数据

const leaderOptions = ref(
    [
      {username: 'shaoyun', id: '1',},
      {username: 'Kaguya', id: '113',}
    ]
);


const saveUserFrom = ref({
      username: '',
      phone: '',
      email: '',
      age: '',
      level: '',
      parentId: '',
      gender: '',
      status: '',
    }
);

const saveUser = () =>{
  console.log(saveUserFrom.value);
  let data = qs.stringify(saveUserFrom.value);
  axios.post(BASE_URL + '/v1/user/save', data).then((response) => {
    if (response.data.code == 2000) {
      ElMessage.success('保存成功');
      dialogVisible.value = false;
      saveUserFrom.value = {};
    }else {
      ElMessage.error(response.data.msg);
    }
  });
}


const handleClose= ()=>{
  if (confirm("你确定要退出编辑吗?")) {
    dialogVisible.value = false;
    saveUserFrom.value = {};
  }
}

// 定义数组来保存用户列表数据

const userArr = ref([
      {username: 'ss', phone: '1231414', createTime: '2020-02-02', status: '1'},
      {username: '324s', phone: '1234534', createTime: '2020-05-02', status: '0'}
    ]
);

// 用来保存查询条件
const searchUserFrom = ref(
    {username:'', status: ''}

)

// 定义加载用户数据的方法
const loadUser=()=>{
  let data = qs.stringify(searchUserFrom.value);
  console.log(data);

  axios.get(BASE_URL+'/v1/user/select?'+data).then((response)=>{
    if (response.data.code === 2000) {
      userArr.value = response.data.data;
    }else {
      ElMessage.error(response.data.msg);
    }
  })
}

onMounted(()=>{
  loadUser();
})

</script>

<style scoped>

</style>