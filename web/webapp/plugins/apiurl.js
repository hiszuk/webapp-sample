export default (context) => {
    context.app.$axios.defaults.baseURL = context.app.$env.API_URL
    console.log(`baseURL: ${context.app.$axios.defaults.baseURL}`)
  }
  