/**
 *   getUrlBase64('https://bizhi1.com/wp-content/uploads/2024/01/dynamic-spider-man-desktop-wallpaper-4k-small.jpg').then((base64) => {
 *     let link = document.createElement("a");
 *     link.href = base64;
 *     link.download = "qrCode.png";
 *     link.click();
 *   });
 */

export async function downloadImage(options: DownloadImageOptions): Promise<void> {
    const {url, filename = "image.png"} = options;

    const response = await fetch(url, {
        headers: {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3'
        }
    });

    if (!response.ok) {
        throw new Error(`Failed to download image: ${response.status}`);
    }

    const blob = await response.blob();
    const newUrl = window.URL.createObjectURL(blob);
    const link = document.createElement('a');
    link.href = newUrl;
    link.download = filename;
    link.click();
    window.URL.revokeObjectURL(newUrl);
}

//判断字符串是否为空
export function isEmpty(str: string | null | undefined): boolean {
    return str === null || str === undefined || str.length === 0;
}

// 输出一个10个字符长度的随机字符串
export function generateRandomString(length: number): string {
    const chars:string = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let result:string = '';
    for (let i:number = 0; i < length; i++) {
        result += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    return result;
}



