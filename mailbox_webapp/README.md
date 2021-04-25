# mailbox_webapp

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Run your tests
```
npm run test
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

### 阿里云短信字数限制：
短信字数＝短信模版内容字数 + 签名字数
短信字数≤70个字数，按照70个字数一条短信计算
短信字数>70个字数，即为长短信，按照67个字数记为一条短信计算
注意：在统计短信字数时，小数点、字母、汉字以及其他符号均按照一个字符位进行统计。最终按照实际发送成功的短信条数计费。
See https://help.aliyun.com/document_detail/44335.html?spm=a2c4g.11186623.6.547.3aa72777AABSMg
