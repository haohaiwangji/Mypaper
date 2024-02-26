"use strict";
const electron = require("electron");
const path = require("path");
require("dotenv").config({ path: ".env.pord" });
let win;
process.env["ELECTRON_DISABLE_SECURITY_WARNINGS"] = "true";
electron.app.commandLine.appendSwitch("lang", "zh-CN");
const createWindow = () => {
  win = new electron.BrowserWindow({
    titleBarStyle: "hidden",
    width: 1080,
    // width: 1620,
    height: 720,
    maxHeight: 720,
    minHeight: 720,
    minWidth: 1080,
    maxWidth: 1080,
    frame: false,
    resizable: true,
    maximizable: false,
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
      preload: path.join(__dirname, "preload.js")
    }
  });
  win.webContents.openDevTools();
  win.loadURL(
    process.env.VITE_NODE_ENV == "development" ? `${process.env["VITE_DEV_SERVER_URL"]}` : `file://${path.join(__dirname, "../dist/index.html")}`
  );
  electron.ipcMain.on("window-min", () => {
    if (win) {
      win.minimize();
    }
  });
  electron.ipcMain.on("window-close", () => {
    if (win) {
      win.close();
    }
  });
};
electron.app.whenReady().then(() => {
  createWindow();
  electron.app.on("activate", () => {
    if (electron.BrowserWindow.getAllWindows().length === 0)
      createWindow();
  });
  electron.app.on("window-all-closed", () => {
    if (process.platform !== "darwin") {
      electron.app.quit();
    }
  });
});
