import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import BbsPage from '@/pages/bbs/index.vue'
import BbsIndexPage from '@/pages/bbs/index/index.vue'
import BlogPage from '@/pages/blog/index.vue'
import ProfilePage from '@/pages/profile/index.vue'
import IndexPage from '@/pages/index.vue'
import blogArticleAddPage from '@/pages/blog/article/add/index.vue'
import BlogIndexPage from '@/pages/blog/index/index.vue'
import BlogArticleIndexPage from '@/pages/blog/article/index/index.vue'
import LeaveMessagePage from '@/pages/leaveMessage/index.vue'
import BlogArticleEditPage from '@/pages/blog/article/edit/index.vue'


const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'index',
    component: IndexPage
  },
  {
    path: '/bbs',
    name: "bbs",
    component: BbsPage,
    children: [
      {
        path: '',
        name: 'bbsIndex',
        component: BbsIndexPage
      },
    ]
  },
  {
    path: '/blog',
    name: "blogHome",
    component: BlogPage,
    children: [
      {
        path: '',
        name: 'blogIndex',
        component: BlogIndexPage
      },

      {
        path: 'article',
        name: 'blogArticle',
        children: [
          {
            path: '',
            component: BlogArticleIndexPage
          },
          {
            path: 'edit',
            name: 'blogArticleEdit',
            component: BlogArticleEditPage,
            meta: {
              hideSider: true
            }
          },
          {
            path: 'add',
            name: 'blogArticleAdd',
            component: blogArticleAddPage,
            meta: {
              hideSider: true
            }
          },
        ]
      }
    ]
  },
  {
    path: '/profile',
    name: "profile",
    component: ProfilePage
  },
  {
    path: '/leaveMessage',
    name: 'leaveMessage',
    component: LeaveMessagePage
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
