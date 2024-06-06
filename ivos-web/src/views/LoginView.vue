<!--登录页-->
<template xmlns:el-col="http://www.w3.org/1999/html">
    <div style="height: 100vh;background-image: linear-gradient(135deg,#1352f2,#3c82f5);overflow: hidden">
      <el-container style="padding: 30px">
        <el-header>
          <el-row :gutter="10">

            <el-col :span="3">
              <img src="/imgs/login/logo.png" style="height: 50px" alt="图片丢了喵~">
            </el-col>

            <el-col :span="1">
              <img src="/imgs/login/auto.png" style="height: 50px" alt="图片丢了喵~">
            </el-col>

            <el-col :span="1">
              <img src="/imgs/login/verticalLine.png" style="height: 50px" alt="图片丢了喵~">
            </el-col>

            <el-col :span="19">
              <span style="color: #fff;font-weight: bold; font-size: 30px">智慧车辆管理系统</span>
            </el-col>

          </el-row>
        </el-header>
        <el-main>
          <el-row :gutter="40">

            <el-col :span="16">
              <img src="/imgs/login/bg.png" style="width: 100%; margin-top: 60px" alt="图片丢了喵~">
            </el-col>

            <el-col :span="8">
              <el-card style="margin-top: 80px">
                <h3 style="text-align: center">用户登录</h3>
                <el-form label-position="top">
                  <el-form-item label="用户名">
                    <el-input placeholder="请输入用户名" v-model="user.username"></el-input>
                  </el-form-item>
                  <el-form-item label="密码">
                    <el-input placeholder="请输入密码" type="password" v-model="user.password"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" style="width: 100%;" @click="login()">登录</el-button>
                  </el-form-item>
                </el-form>
                <div style="color: #666; text-align: center;font-size: 14px;padding: 10px 0">
                  (体验账号:tom 密码:123456)
                </div>
              </el-card>
            </el-col>

          </el-row>

        </el-main>
      </el-container>
    </div>
</template>


<script setup>
import {ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";

const user = ref({username:'', password: ''});
const login =()=>{
  axios.post("http://localhost:8080/v1/user/login", user.value)
      .then((response)=>{
        if (response.data.code === 2000) {
          ElMessage.success("登录成功");
        }else {
          ElMessage.error(response.data.msg);
        }
        console.log(response.data);
      });
}
</script>

<style scoped>

</style>
<script setup>
</script>