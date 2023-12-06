import {createRouter, createWebHashHistory} from "vue-router";
import Home from "../views/Home.vue";
import DashBord from "../views/DashBord.vue";

const routes = [
    {
        path: '/',
        components: {
            Home
        }
    },
    {
        path: '/dashBord', component: DashBord
    },
    {
        path: '/about',
        name: 'about',
        component: () => import('../views/About.vue')
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('@/views/Login.vue')
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

router.beforeEach((to, from) => {
    console.log("to : ", to);
    console.log("from : ", from)
    let user = sessionStorage.getItem("user");
    console.log(user);
    if (to.path !== '/login' && !user) {
        return {
            name: 'login'
        }
    }
})

export default router