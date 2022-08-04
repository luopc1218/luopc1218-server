export interface Api {
    url: string,
    method: 'get' | 'post'
}

export const apis: Record<string, Api> = {
    checkSignIn: {
        url: "/api/user/checkSignIn",
        method: "get"
    },
    getUserInfo: {
        url: "/api/user/getUserInfo",
        method: "get"
    },
    getNavLink: {
        url: '/api/getNavLink',
        method: "get"
    },
    upload: {
        url: '/api/file/upload',
        method: 'post'
    },
    getCountryTelCodeList: {
        url: '/api/getCountryTelCodeList',
        method: "get"
    },
    checkSignUpUsername: {
        url: "/api/user/checkSignUpUsername",
        method: "get"
    },
    sendPhoneCheckCode: {
        url: "/api/sendPhoneCheckCode",
        method: 'post'
    },
    signUp: {
        url: "/api/user/signUp",
        method: "post"
    },
    signIn: {
        url: '/api/user/signIn',
        method: "post"
    },
    getArticleTagList: {
        url: '/api/article/getArticleTagList',
        method: 'get'
    },
    addArticle: {
        url: '/api/article/addArticle',
        method: 'post'
    },
    getArticleList: {
        url: '/api/article/getArticleList',
        method: "get"
    },
    getArticleInfo: {
        url: '/api/article/getArticleInfo',
        method: "get"
    },
    getAdminInfo: {
        url: '/api/user/getAdminInfo',
        method: "get"
    },
    addLeaveMessage: {
        url: "/api/message/addLeaveMessage",
        method: 'post'
    },
    getLeaveMessageList: {
        url: "/api/message/getLeaveMessageList",
        method: "get"
    }
}

export default apis