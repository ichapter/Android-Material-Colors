# Android Material Colors #

[![Build Status](https://travis-ci.org/TakWolf/Android-Material-Colors.svg?branch=master)](https://travis-ci.org/TakWolf/Android-Material-Colors)
[![Download](https://api.bintray.com/packages/takwolf/maven/Android-Material-Colors/images/download.svg)](https://bintray.com/takwolf/maven/Android-Material-Colors/_latestVersion)
[![Platform](https://img.shields.io/badge/platform-Android-green.svg?style=flat)](https://www.android.com)
[![API](https://img.shields.io/badge/API-1%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=1)
[![License](https://img.shields.io/github/license/TakWolf/Android-Material-Colors.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

谷歌 Material Design 标准颜色。

官方文档地址为：[https://material.io/guidelines/style/color.html](https://material.io/guidelines/style/color.html)

调色板资源文件通过 `doc-getter` 自动抓取生成。

## Usage ##

### Gradle ###

```
compile 'com.takwolf.android.materialdesign:color:0.0.1'
```

### Style ###

```
<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
    <item name="colorPrimary">@color/material_indigo_500</item>
    <item name="colorPrimaryDark">@color/material_indigo_700</item>
    <item name="colorAccent">@color/material_pink_a200</item>
</style>
```

## Author ##

TakWolf

[takwolf@foxmail.com](mailto:takwolf@foxmail.com)

[http://takwolf.com](http://takwolf.com)

## License ##

```
Copyright 2015 TakWolf

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
