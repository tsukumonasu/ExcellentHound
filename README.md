# ExcellentHound
DatadogのmonitorとeventsをExcelで確認したいひと向け。  
そのうち、importにも対応したい。

## 使用方法

### Windowsの場合
excellenthound.bat をテキストエディタを開き
APIキーとAPPキーを設定してください。
設定後、 excellenthound.bat を実行してください。

設定例
```
rem DatadogのAPIキーを指定
set DATADOG_API_KEY=

rem Datadogのアプリキーを指定
set DATADOG_APP_KEY=

rem 出力対象を指定
rem events or monitor
set DATADOG_API=events

rem events出力の場合、出力期間を指定
set START_DATE=2017/09/18 00:00:00
set END_DATE=2017/09/21 00:00:00

rem 出力するExcelのタイトルを指定
set EXELE_FILE_TITLE=naikitest
```

### Mac/Linuxの場合
excellenthound.sh をテキストエディタを開き、以下を設定してください。
設定後、excellenthound.sh を実行してください。

設定例
```
# DatadogのAPIキーを指定
export DATADOG_API_KEY=

# Datadogのアプリキーを指定
export DATADOG_APP_KEY=

# 出力対象を指定
# events or monitor
export DATADOG_API=monitor

# events出力の場合、出力期間を指定
export START_DATE='2017/09/18 00:00:00'
export END_DATE='2017/09/21 00:00:00'

# 出力するExcelのタイトルを指定
export EXELE_FILE_TITLE=naikitest
```

## Excel出力フォーマット変更について
template/events.xlsx template/monitor.xlsx を編集し、
conf/hound.yaml で出力位置を修正してください。
