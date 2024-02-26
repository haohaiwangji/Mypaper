//store中的数据类型
type storeType = {
    isBack:string,
    searchValue:string,
    ImgList:DetailType[],
    page:number,
    WakHavenContentList: paperListType[],
    WakHavenTopList: paperListType[],
    BirdContentList:paperListType[],
    Wall360ContentList:paperListType[],
    modelList:paperListType[],
    ApiSetUpList:paperListType[],
    topicSetUpList:paperListType[]
}
//图片数据type
type ImgListType={
    cover:string,
    imgContent:string,
    imgHref:string
}
//图片类别type
type paperListType={
    value:string,
    label:string
}
//弹窗详情
type DetailType = {
    category?: string,
    imgCover?: string
    realImg?: string,
    realSize?: string,
    realTitle?: string,
    resolution?: string,
}
//下载图片参数Type
type DownloadImageOptions = {
    url: string;
    filename?: string;
};

