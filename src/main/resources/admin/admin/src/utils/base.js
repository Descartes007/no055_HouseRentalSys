const base = {
    get() {
                return {
            url : "http://localhost:8080/springboot08hr3/",
            name: "springboot08hr3",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot08hr3/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "房屋租赁系统"
        } 
    }
}
export default base
