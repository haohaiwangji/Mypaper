import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import path from 'path';
import AutoImport from 'unplugin-auto-import/vite';
import Components from 'unplugin-vue-components/vite';
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers';
import electron from "vite-plugin-electron";
export default defineConfig({
    base: "./",
    plugins: [
        vue(),
        electron({
            entry: "electron/index.ts"
        }),
        AutoImport({
            resolvers: [ElementPlusResolver()],
        }),
        Components({
            resolvers: [ElementPlusResolver()],
        }),
    ],
    resolve: {
        alias: {
            "@": path.resolve(__dirname, "./src"),
        },
        extensions: [".mjs", ".js", ".ts", ".jsx", ".tsx", ".json", ".vue"],
    },
    // //设置跨域
    // server: {
    //     proxy: {
    //         '/api': {
    //             target: 'http://127.0.0.1:8080',
    //             changeOrigin: true,
    //             rewrite: (path) => path.replace(/^\/api/, ""),
    //         }
    //     }
    // },
    css: {
        preprocessorOptions: {
            less: {
                additionalData: "@import \"@/style.less\";"
            },
        },
    },
});
