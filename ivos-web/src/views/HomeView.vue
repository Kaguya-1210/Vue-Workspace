<template>
  <!--display: flex;表示给父元素使用弹性布局
  效果:所有子元素横置,且父元素会根据子元素横置后的实际高度自动填充高度 -->
  <div style="display: flex;">
    <!-- 左侧菜单栏 可折叠 折叠时宽度为64px 不折叠时宽度为208px -->
    <div :style="{width:( isCollapse ? '64px' : '208px' )}">
      <el-menu background-color="#3C82F5"
               text-color="#fff"
               style="width:100%;height:100%;min-height:100vh;"
               active-text-color="#ff0"
               :collapse="isCollapse"
               :collapse-transition="false"
               router
               unique-opened
      >


        <el-row style="padding-top: 10px">
          <el-col span="2"></el-col>
          <el-col span="7" style="padding-left:16px;">
            <el-avatar src="/imgs/admin/logo.png" style="width: 35px;height: 35px;"></el-avatar>
          </el-col>

          <el-col :span="isCollapse ? 0:13">
            <router-link to="/" style="color:#fff;text-decoration:none;font-weight:bold;position:relative;top:8px;left:19px;">
              智慧车辆
            </router-link>
          </el-col>

          <el-sub-menu index="1" style="width: 30vh">
            <template #title>
              <el-icon style="font-size:19px;">
                <User/>
              </el-icon>
              <span>用户管理</span>
            </template>
            <el-menu-item index="/user">用户管理</el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="2" style="width: 30vh">
            <template #title>
              <el-icon style="font-size: 19px">
                <Van/>
              </el-icon>
              <span>车辆管理</span>
            </template>
            <el-menu-item index="/vehicle">基本信息</el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="3" style="width: 30vh;">
            <template #title>
              <el-icon style="font-size: 19px">
                <Place/>
              </el-icon>
              <span>调度管理</span>
            </template>
            <el-menu-item index="/application">申请列表</el-menu-item>
            <el-menu-item index="/audit">调度审核</el-menu-item>
            <el-menu-item index="/distribute">车辆分配</el-menu-item>
          </el-sub-menu>


          <el-sub-menu index="4" style="width: 30vh;">
            <template #title>
              <el-icon style="font-size:19px;">
                <Location/>
              </el-icon>
              <span>电子围栏</span>
            </template>
            <el-menu-item index="/geofence">围栏管理</el-menu-item>
          </el-sub-menu>


          <el-sub-menu index="5" style="width: 30vh;">
            <template #title>
              <el-icon style="font-size:19px;">
                <MessageBox/>
              </el-icon>
              <span>数据字典</span>
            </template>
            <el-menu-item index="/dict">字典管理</el-menu-item>
          </el-sub-menu>
        </el-row>
      </el-menu>
    </div>
    <!-- 右侧主体内容 永远占满剩余宽度 -->
    <div :style="{width:(isCollapse ? 'calc(100% - 64px)' : 'calc(100% - 208px)')}">
      <router-view>

      </router-view>
    </div>
  </div>
</template>


<script setup>
import {ref} from "vue";

const User = ref(getUser());

const isCollapse = ref(false);

</script>