# Android Library Module

这是一个Android库模块，可以方便地封装功能并通过JitPack发布。

## 模块结构

```
library/
├── src/main/
│   ├── java/com/pic/preview/
│   │   ├── ExampleLibrary.kt          # 示例库类
│   │   ├── utils/EasyStringUtils.kt   # 工具类
│   │   └── extensions/ViewExtensions.kt # 扩展函数
│   ├── res/                          # 资源文件
│   └── AndroidManifest.xml           # 清单文件
├── build.gradle                      # 模块构建配置
├── proguard-rules.pro                # 混淆规则
├── consumer-rules.pro                # 消费者规则
└── gradle.properties                 # 发布配置
```

## 使用方法

### 1. 在项目中添加依赖

在app模块的build.gradle中添加：

```gradle
dependencies {
    implementation project(':library')
}
```

### 2. 使用库功能

```kotlin
// 使用示例库
val library = ExampleLibrary.getInstance(context)
library.showMessage("Hello from library!")

// 使用工具类
val formattedTime = StringUtils.formatTimestamp(System.currentTimeMillis())

// 使用扩展函数
view.setVisible(true)
view.setOnClickListenerWithDebounce { 
    // 防抖点击处理
}
```

## 通过JitPack发布和使用

### 发布步骤：

1. **将代码推送到GitHub**：
   ```bash
   git add .
   git commit -m "发布版本 1.0.0"
   git tag -a 1.0.0 -m "版本 1.0.0"
   git push origin main --tags
   ```

2. **JitPack会自动构建**：
   - 访问 https://jitpack.io/#BlackBackView/simple-picture-preview
   - JitPack会自动检测新标签并开始构建

3. **检查构建状态**：
   - 绿色表示构建成功
   - 点击"Get it"查看依赖配置

### 在其他项目中使用（通过JitPack）：

1. **添加JitPack仓库**（如果还没有）：
   ```gradle
   allprojects {
       repositories {
           // ... 其他仓库
           maven { url 'https://jitpack.io' }
       }
   }
   ```

2. **添加依赖**：
   ```gradle
   dependencies {
       implementation 'com.github.BlackBackView:simple-picture-preview:1.0.0'
   }
   ```

### 版本说明：

- **使用具体版本号**：`1.0.0`
- **使用最新提交**：`main-SNAPSHOT`（不推荐）
- **使用标签**：`1.0.0`（推荐）

## 本地测试发布

```bash
# 发布到本地Maven仓库
./gradlew :library:publishToMavenLocal

# 在其他项目中测试
# 在测试项目的build.gradle中添加：
# implementation 'com.github.BlackBackView:simple_picture_preview:1.0.0'
```

## 添加新功能

1. 在`src/main/java/com/pic/preview/`目录下创建新的Kotlin文件
2. 实现你的功能
3. 更新版本号（在`gradle.properties`中修改`VERSION_NAME`）
4. 创建新标签并推送到GitHub

## JitPack注意事项

1. **确保项目能正常构建**：JitPack会在干净环境中构建
2. **使用正确的group ID**：必须是`com.github.用户名`
3. **添加必要的配置**：`jitpack.yml`文件可帮助构建
4. **检查构建日志**：如果失败，查看JitPack的构建日志

## 版本管理

- 使用语义化版本控制（SemVer）
- 主版本号：不兼容的API变更
- 次版本号：向后兼容的功能性新增
- 修订号：向后兼容的问题修正
- 每次发布创建Git标签