import {defineStore} from 'pinia'

export const useStore = defineStore('paperInfo', {
    state: ():storeType => {
        return {
            //控制导航栏菜单选中的颜色显示和隐藏
            isBack:"home",
            searchValue:"",
            //图片列表
            ImgList:[],
            //页面pageid
            page:1,
            WakHavenContentList: [
                {value: 'getLatestImg', label: '最新'},
                {value: 'getHotImg', label: '热门'},
                {value: 'getCategoriesImg', label: '常规'},
                {value: 'getAnimeImg', label: '动漫'},
                {value: 'getLandscapeImg', label: '风景'},
                {value: 'getCarImg', label: '汽车'},
                {value: 'getGameImg', label: '游戏'},
                {value: 'getSystemImg', label: '系统'},
            ],
            WakHavenTopList: [
                {value: '1y', label: '去年'},
                {value: '6M', label: '过去6个月'},
                {value: '3M', label: '过去三个月'},
                {value: '1M', label: '上个月'},
                {value: '1w', label: '上个星期'},
                {value: '3d', label: '前三天'},
                {value: '1d', label: '前一天'}
            ],
            BirdContentList: [
                {value: 'get4kImg', label: '4k'},
                {value: 'getWomanImg', label: '美女'},
                {value: 'getLoveImg', label: '爱情'},
                {value: 'getSceneryImg', label: '风景'},
                {value: 'getFreshnessImg', label: '小清新'},
                {value: 'getAnimeImg', label: '动漫'},
                {value: 'getStarImg', label: '明星'},
                {value: 'getPetImg', label: '萌宠'},
                {value: 'getGameImg', label: '游戏'},
                {value: 'getCarImg', label: '汽车'},
                {value: 'getVogueImg', label: '时尚'},
                {value: 'getDateImg', label: '月历'},
                {value: 'getFilmImg', label: '影视'},
                {value: 'getFestivalImg', label: '节日'},
                {value: 'getArmyImg', label: '军事'},
                {value: 'getPhysicalImg', label: '体育'},
            ],
            Wall360ContentList: [
                {value:'getNewImg',label:'最新'},
                {value: 'get4kImg', label: '4k'},
                {value: 'getWomanImg', label: '美女'},
                {value: 'getLoveImg', label: '爱情'},
                {value: 'getSceneryImg', label: '风景'},
                {value: 'getFreshnessImg', label: '小清新'},
                {value: 'getAnimeImg', label: '动漫'},
                {value: 'getStarImg', label: '明星'},
                {value: 'getPetImg', label: '萌宠'},
                {value: 'getGameImg', label: '游戏'},
                {value: 'getCarImg', label: '汽车'},
                {value: 'getVogueImg', label: '时尚'},
                {value: 'getDateImg', label: '月历'},
                {value: 'getFilmImg', label: '影视'},
                {value: 'getFestivalImg', label: '节日'},
                {value: 'getArmyImg', label: '军事'},
                {value: 'getPhysicalImg', label: '体育'},
            ],
            modelList:[
                {value: '动漫2D', label: '二次元风格模型1'},
                {value: 'Cutten', label: '二次元风格模型2'},
                {value: 'baitianmixv', label: '二次元风格模型3'},
                {value: '清心', label: '二次元风格模型4'},
                {value: 'AWPainting', label: '二次元风格模型5'},
                {value: 'youkengi', label: '二次元风格模型6'},
                {value: '墨幽', label: '实风人物模型1'},
                {value: '赛博', label: '实风人物模型2'},
                {value: '极氪写实PRO', label: '实风人物模型pro1'},
                {value: 'MiaoKa', label: '实风人物模型pro2'},
                {value: '可爱多', label: '二次元可爱型模型'},
                {value: 'Sillustration', label: '可爱儿童风格模型'},
                {value: '银白蔷薇', label: '二次元插画风的模型'},
                {value: '漫画', label: '漫画风格的模型'},
                {value: 'Somman_2.5D', label: '2.5D人物次元模型'},
                {value: 'LarmeKei', label: '画风独特次元风模型'},
                {value: 'Game技能图标', label: '游戏技能次元模型'},
            ],
            ApiSetUpList: [
                {value: 'wall360', label: '壁纸1'},
                {value: 'wall', label: '壁纸2'},
                {value: 'bird', label: '壁纸3'},
            ],
            topicSetUpList: [
                {value: 'light', label: '明亮'},
                {value: 'dark', label: '暗黑'},
            ],

        }
    },
    getters: {},
    actions: {},

    // persist: {
    //     enabled: true,
    //     // 设置pinia存储方式
    //     strategies: [
    //         {
    //             key: "userInfo",
    //             storage: localStorage,
    //             paths: ['LoginInfo']
    //         },
    //         {
    //             key: "navMenu",
    //             storage: sessionStorage,
    //             paths: ['navMenu', 'collapseIcon', 'menuTabs', 'activeIndexTab']
    //         }
    //     ]
    // }
})
