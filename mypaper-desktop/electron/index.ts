
import { app, BrowserWindow,ipcMain } from 'electron'
import path from 'path'

require('dotenv').config({ path: '.env.pord' });


// 定义全局变量，获取窗口实例
let win: BrowserWindow | null;
// 禁用安全警告
process.env["ELECTRON_DISABLE_SECURITY_WARNINGS"] = "true";

app.commandLine.appendSwitch('lang', 'zh-CN')

/**
 * 创建一个窗口
 */
const createWindow = () => {
    win = new BrowserWindow({
        titleBarStyle: 'hidden',
        width: 1080,
        // width: 1620,
        height: 720,
        maxHeight: 720,
        minHeight: 720,
        minWidth: 1080,
        maxWidth: 1080,

        frame: false,
        resizable: true,
        maximizable:false,
        // show:false,
        webPreferences: {
            //调试工具
            devTools: true,
            // devTools: false,
            webSecurity: false,
            nodeIntegration: true,
            contextIsolation: false,
            allowRunningInsecureContent: false,
            nodeIntegrationInWorker: true,
            preload: path.join(__dirname, 'preload.js'),
        }
    })
    win.webContents.openDevTools()
    //mac os隐藏窗口按钮
    // win.setWindowButtonVisibility(false)

    // 新增判断当前环境
    win.loadURL(
        process.env.VITE_NODE_ENV == 'development'
            ? `${process.env['VITE_DEV_SERVER_URL']}`
            :`file://${path.join(__dirname, '../dist/index.html')}`
    );
    //最小化窗口
    ipcMain.on('window-min',()=>{
        if(win){
            win.minimize()
        }
    });
    //关闭窗口
    ipcMain.on('window-close',()=>{
        if(win){
            win.close()
        }
    });

}



app.whenReady().then(() => {
    createWindow() // 创建窗口
    app.on("activate", () => {
        if (BrowserWindow.getAllWindows().length === 0) createWindow()
    })
    app.on('window-all-closed', () => {
        if (process.platform !== 'darwin') {
            app.quit()
        }
    })
})
