<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    submit() {
      console.log(this.username,this.password)
      sessionStorage.setItem("user",this.username)
      this.$router.push("dashBord")
    }
  }
}
</script>

<template>
  <div>
    <h2>登录</h2>
    <label>用户名
      <input type="text" v-model="username" placeholder="请输入用户名"/>
    </label>
    <label>密码
      <input type="password" v-model="password" placeholder="请输入密码"/>
    </label>
    <el-button @click="submit">登录</el-button>
  </div>
</template>

<style scoped>

</style>