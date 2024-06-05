
<template>
  <div>
    <label>
      姓名:
      <input type="text" v-model="username">
      <br>
      薪资:
      <input type="number" v-model="salary">
      <br>
      <button v-on:click="addSalary()">提交</button>
    </label>
  </div>
  <hr>
  <button v-on:click="changShowInfo">展开信息表</button>
  <div id="userinfo" v-if="showInfo">
    <h1>个人信息表</h1>
    <label>
      年龄:
      <input type="number" v-model="userinfo.age">
      <br>
      性别:
      <input type="radio" value="1" v-model="userinfo.sex">男
      <input type="radio" value="0" v-model="userinfo.sex"> 女
      <br>
      岗位:
      <select v-model="userinfo.job">
        <option value="dev">开发</option>
        <option value="test">测试</option>
      </select>
      <br>
      技术:
      <span v-for="skill in userinfo.skills" :key="skill">{{ skill }}</span>
      <hr>
      添加技术:
      <input type="text" v-model="newSkills">
     <button v-on:click="addNewSkill">添加技能</button>
      <hr>
      个人信息总汇:
      <span>{{ userinfo }}</span>
    </label>
  </div>
</template>

<script>
  export default{
    data(){
      return{
        username: "Kaguya",
        salary: 99599,
        userinfo: {
          age: 17,
          sex: 1,
          job: "dev",
          skills: ['java', 'vue']
        },
        newSkills: '',
        showInfo: false,
      }
    },
    methods:{
      addSalary() {
        this.salary += 1000

      },
      addNewSkill() {
        this.userinfo.skills.push(this.newSkills);
      },
      changShowInfo() {
        this.showInfo = !this.showInfo;
      },
    }
  }
</script>

<style scoped>

</style>
