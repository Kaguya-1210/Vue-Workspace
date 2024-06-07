<!--用户管理页-->

<template>
  <div style="height: 6vh;background-color: #fff;padding: 10px 20px">
    <span style="font-size: 20px;line-height: 60px">用户管理</span>
    <el-button @click="dialogVisible=true" type="primary" style="float: right; margin-top: 10px">新建用户</el-button>
    <el-dialog :title="dialogTitle" v-model="dialogVisible" style="width: 1000px;padding: 40px">

      <el-form label-position="top" label-width="80px">


        <el-row :gutter="30">


          <el-col :span="12">

            <el-form-item label="用户名">

              <el-input placeholder="请输入用户名"></el-input>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="手机号">

              <el-input placeholder="请输入手机号"></el-input>

            </el-form-item>

          </el-col>
        </el-row>

        <el-row :gutter="30">


          <el-col :span="12">

            <el-form-item label="邮箱">

              <el-input placeholder="请输入邮箱"></el-input>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="年龄">

              <el-input placeholder="请输入年龄"></el-input>

            </el-form-item>

          </el-col>


        </el-row>


        <el-row :gutter="30">
          <el-col :span="6">
            <el-form-item label="职级">
              <el-select placeholder="请选择">
                <el-option v-for="item in levelOptions" :label="item.label"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="直属领导">
              <el-select placeholder="请选择">
                <el-option label="shaoyun" value="1"></el-option>
                <el-option label="mike" value="2"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="性别">
              <el-radio-group>
                <el-radio label="男" border value="1" style="margin: 0;"></el-radio>
                <el-radio label="女" border value="0"></el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="用户状态">
              <el-radio-group>
                <el-radio label="启用" border value="1" style="margin: 0;"></el-radio>
                <el-radio label="禁用" border value="0"></el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>

      <template #footer>
        <el-button>取消</el-button>
        <el-button type="primary">保存</el-button>
      </template>


    </el-dialog>
  </div>
</template>

<script setup>

import {ref} from "vue";

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
      {username: 'mike', id: '2',}
    ]
);


</script>

<style scoped>

</style>