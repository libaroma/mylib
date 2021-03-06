package com.mylib.hyz.libblog.utils.getItem;

import java.util.List;

public class GetTopArticleListItem {

    /**
     * success : true
     * code : 2011
     * message : 获取成功！
     * data : [{"id":"806656525832552448","title":"Vuex实现组件间通讯","userId":"766394825724395520","categoryId":"776572170389159936","content":"#  引言\n\n 最近在写博客系统门户，在写登录部分的时候，由于把各个页面元素都抽成了单个组件，所以在实现登录和退出登陆的时候，组件之间的通讯较为繁琐，查询了一下，发现可以通过vuex实现管理层，相较于跳转之后刷新页面的用户体验要好很多，下面简单记录一下。\n\n\n# vue.js\n先提一下vue\n\n官网地址：`https://vuejs.org/`\n![image](/portal/image/get/XH*&&*1612367272470_806672337532354560.png?mode=scale&scale=0.95)\n> Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。\n\n# nuxt.js\n再提一下nuxt\n\n官网地址：`https://zh.nuxtjs.org`\n![image](/portal/image/get/XH*&&*1612367288045_806672402850250752.png?mode=scale&scale=0.95)\n> Nuxt.js 是一个基于 Vue.js 的轻量级应用框架,可用来创建服务端渲染 (SSR) 应用,也可充当静态站点引擎生成静态站点应用,具有优雅的代码结构分层和热加载等特性。\n\n# vuex\n最后提一下vuex\n\n官网地址：`https://vuex.vuejs.org/zh/`\n\n> Vuex 是一个专为 Vue.js 应用程序开发的状态管理模式。它采用集中式存储管理应用的所有组件的状态，并以相应的规则保证状态以一种可预测的方式发生变化。Vuex 也集成到 Vue 的官方调试工具 `devtools extension (opens new window)`，提供了诸如零配置的 time_dark-travel 调试、状态快照导入导出等高级调试功能。\n\n# 正文\n\n下面梳理一下实现的流程\n\n- 安装`vuex`\n\n\n```\nnpm install vuex --save\n```\n- 安装`promise`\n\n```\nnpm install es6-promise --save \n```    \n- 引入`vuex`\n\n\n   \n   在`plugins`目录下，创建`/store/index.js` 文件，写入\n![image](/portal/image/get/XH*&&*1612367304941_806672473876594688.png?mode=scale&scale=1)\n```\n    import 'es6-promise/auto'\n    import Vue from 'vue'\n    import Vuex from 'vuex'\n    import * as  api from \"../../api/api\"\n    Vue.use(Vuex)\n    const store = new Vuex.Store({\n\t\tstate: {\n     \t  userInfo: null\n        },\n\t\tmutations: {\n \t \t  getUserInfo(state) {\n  \t\t    api.checkToken().then(res=>{\n  \t           if(res.code==2003){\n  \t\t \t       state.userInfo =res.data\n  \t   \t    }else {\n \t \t \t       state.userInfo=null\n \t \t   \t}\n  \t   \t })\n\t        }\n\t     }\n \t})\n\texport  default  store\n```\n- 在`nuxt.config.js`中配置\n```\n      plugins: [\n          '@/plugins/store/index.js'\n     ]\n```\n- 用户信息显示页面引入\n\n```\n    <template>\n        <user-info  :user-info=\"userInfo\" />\n    <\/template>\n     <script>\n\t  import store from \"../plugins/store\";\n\n \t export default {\n   \t computed:{\n    \t  userInfo(){\n      \t  console.log(store.state.userInfo)\n     \t   return store.state.userInfo\n    \t   }\n        }\n      }\n\t<\/script>\n```    \n - 登录和退出登录时和时发起`commit`\n \n ```\n    methods: {\n         //发起登录\n      doLogin() {\n        api.doLogin(this.login_day.captcha, this.captcha_key, this.IsPC(), {\n          userName: this.login_day.userName,\n          password: this.login_day.password\n        }).then(res => {\n            //处理结果\n            let code = res.code\n            if (code == 2999) {\n              this.$Message.success('Success!');\n              //跳转\n              if (this.$route.query.redirect) {\n                let path = this.$route.query.redirect\n                this.$router.push({\n                  path: path\n                });  \n              } else {\n                this.$router.push({name: 'index'});\n              }\n            //发起commit，调用getUserInfo方法，获取用户信息\n            store.commit(\"getUserInfo\")\n         })\n       },\n       //退出登录\n       doLogout(){\n           this.$Modal.confirm({\n            title:\"Warning!\",\n            content:\"确定要退出登陆嘛？\",\n            onOk(){\n              api.doLogout().then(res=>{\n                this.$message.success(res.message)\n                //发起commit，调用getUserInfo方法，获取用户信息\n                store.commit(\"getUserInfo\")\n              })\n            }\n          })\n        }\n     }\n ```     \n  - 解释\n  \n  \n  上文通过`store/index.js`引入`vuex`，定义了一个简单的`store`，其中`state`的对象`userInfo`用于存储用户信息，并且定义了一个`mutation: getUserInfo `\n  \n  `getUserInfo`的作用在于获取用户信息并写入`state.userInfo`\n  \n  > 更改 `Vuex`的 `store` 中的状态的唯一方法是提交 `mutation`。`Vuex `中的 `mutation` 非常类似于事件：每个` mutation` 都有一个字符串的 事件类型` (type)` 和 一个 回调函数 `(handler)`。这个回调函数就是我们实际进行状态更改的地方，并且它会接受 `state `作为第一个参数：   \n  ```  \n    const store = new Vuex.Store({\n\t\tstate: {\n     \t  userInfo: null\n        },\n\t\tmutations: {\n \t \t  getUserInfo(state) {\n  \t\t    api.checkToken().then(res=>{\n  \t           if(res.code==2003){\n  \t\t \t       state.userInfo =res.data\n  \t   \t    }else {\n \t \t \t       state.userInfo=null\n \t \t   \t}\n  \t   \t })\n\t        }\n\t     }\n \t})\n```\n 上述工作完成以后，便可以实现组件间、不同页面间的通讯了。\n \n 通过 `store.state` 来获取状态对象\n ```\n    userInfo(){\n       console.log(store.state.userInfo)\n       return store.state.userInfo\n     }\n ``` \n 通过 `store.commit `方法触发状态变更：\n```    \n    store.commit(\"getUserInfo\")\n```\n - 成果展示\n \n\n [Vuex实现组件间通讯](https://mp.weixin.qq.com/s/B_tsTibuJw1JESDuq1JYcw)\n \n","type":"1","state":"3","coverImg":"/portal/image/get/XH*&&*1613376732860_810906321120395264.png?mode=scale&scale=0.5","summary":"通过vuex实现管理层，相较于跳转之后刷新页面的用户体验要好很多","labels":"vue-nuxtjs-vuex-博客系统","viewCount":472,"publishTime":1612506265326,"updateTime":1613376759428,"libUserNoPassword":{"id":"766394825724395520","userName":"小惠","roles":"role_admin","avatar":"/portal/image/get/XH*&&*1614950149502_817505709435387904.png","email":"mylibhyz@163.com","sign":"明天你好鸭哈","state":"1","createTime":"2020-10-15T12:19:25.000+0000","updateTime":"2021-03-05T13:17:41.000+0000","reg_ip":"0:0:0:0:0:0:0:1","login_ip":"58.194.168.76"},"labelArr":["vue","nuxtjs","vuex","博客系统"]},{"id":"810906044153724928","title":"Ubuntu18.04彻底删除MySQL数据库","userId":"766394825724395520","categoryId":"776572170389159936","content":"\n![image](/portal/image/get/XH*&&*1613376614226_810905824326057984.png)\n\n首先在终端中查看MySQL的依赖项：dpkg --list|grep mysql\n\n卸载： sudo apt-get remove mysql-common\n\n卸载：sudo apt-get autoremove --purge mysql-server-5.7\n\n清除残留数据：dpkg -l|grep ^rc|awk '{print$2}'|sudo xargs dpkg -P\n\n再次查看MySQL的剩余依赖项：dpkg --list|grep mysql\n\n继续删除剩余依赖项，如：sudo apt-get autoremove --purge mysql-apt-config\n\n至此已经没有了MySQL的依赖项，彻底删除，Good Luck","type":"1","state":"3","coverImg":"/portal/image/get/XH*&&*1613376614226_810905824326057984.png","summary":"卸载ubuntu","labels":"mysql-ubuntu","viewCount":8,"publishTime":1613376666832,"updateTime":1613376666832,"libUserNoPassword":{"id":"766394825724395520","userName":"小惠","roles":"role_admin","avatar":"/portal/image/get/XH*&&*1614950149502_817505709435387904.png","email":"mylibhyz@163.com","sign":"明天你好鸭哈","state":"1","createTime":"2020-10-15T12:19:25.000+0000","updateTime":"2021-03-05T13:17:41.000+0000","reg_ip":"0:0:0:0:0:0:0:1","login_ip":"58.194.168.76"},"labelArr":["mysql","ubuntu"]}]
     */

    private boolean success;
    private int code;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends GetArticleItem {
    }
}
