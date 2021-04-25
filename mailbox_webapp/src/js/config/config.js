export default {
  PROXY_ROUTER: {
    LOCALHOST: {
      HOST: "localhost:8080",
      PROXY_HOST: "https://devproxy.xueqiao.cn"
    },
    DEV: {
      HOST: "errorcode-manager.devoa.xueqiao.cn",
      PROXY_HOST: "https://devproxy.xueqiao.cn"
    },
    GAMMA: {
      HOST: "errorcode-manager.gaoa.xueqiao.cn",
      PROXY_HOST: "https://gaproxy.xueqiao.cn"
    },
    IDC: {
      HOST: "errorcode-manager.oa.xueqiao.cn",
      PROXY_HOST: "https://proxy.xueqiao.cn"
    }
  },
  HELP: {
    MESSAGE_VARIABLE_USAGE: {
      DESCRIPTION: "信箱消息发送渠道",
      TITLE: "消息变量使用说明",
      CONTENT:
        "消息内容中可以使用消息变量。使用消息变量，发送时，会替换成对应的变量值。 {{userName}} : 用户中文名; {{companyCode}} : 公司登录名。"
    },
    SUMMARY_SMS_LIMIT: {
      DESCRIPTION: "阿里云短信限制说明",
      TITLE: "概要说明",
      CONTENT: "概要的内容主要做为手机短信的内容。根据阿里云上的短信限制。我们推荐的概要字数为45，但不会强制要求。如果概要字数超过45时，短信有可能会分为多条发送（也会按多条短信计费）。"
    }
  },
  ENUM: {
    M_SENDING_CHANNEL: {
      DESCRIPTION: "信箱消息发送渠道",
      ITEMS: [
        {
          KEY: "MSC_MAIL",
          VALUE: 1,
          LABEL: "电子邮件"
        },
        {
          KEY: "MSC_SMS",
          VALUE: 2,
          LABEL: "手机短信"
        },
        {
          KEY: "MSC_HOSTING",
          VALUE: 4,
          LABEL: "客户端消息"
        }
      ],
      MAP: {
        1: {
          KEY: "MSC_MAIL",
          VALUE: 1,
          LABEL: "电子邮件"
        },
        2: {
          KEY: "MSC_SMS",
          VALUE: 2,
          LABEL: "手机短信"
        },
        4: {
          KEY: "MSC_HOSTING",
          VALUE: 4,
          LABEL: "客户端消息"
        }
      }
    },
    M_TYPE: {
      DESCRIPTION: "信箱消息类型",
      ITEMS: [
        {
          KEY: "TYPE_XUEQIAO_NOTICE",
          VALUE: 0,
          LABEL: "雪橇通知"
        },
        {
          KEY: "TYPE_SYSTEM_NOTICE",
          VALUE: 1,
          LABEL: "系统通知"
        },
        {
          KEY: "TYPE_EXCHANGE_NOTICE",
          VALUE: 2,
          LABEL: "交易所通知"
        },
        {
          KEY: "TYPE_MARKETING_PROMOTION",
          VALUE: 3,
          LABEL: "营销推广"
        }
      ]
    },
    M_LEVEL: {
      DESCRIPTION: "信箱消息级别",
      ITEMS: [
        {
          KEY: "LEVEL_LOW",
          VALUE: 0,
          LABEL: "一般"
        },
        {
          KEY: "LEVEL_MEDIUM",
          VALUE: 10,
          LABEL: "重要"
        },
        {
          KEY: "LEVEL_HIGH",
          VALUE: 20,
          LABEL: "紧急"
        }
      ],
      MAP: {
        0: {
          KEY: "LEVEL_LOW",
          VALUE: 0,
          LABEL: "一般"
        },
        10: {
          KEY: "LEVEL_MEDIUM",
          VALUE: 10,
          LABEL: "重要"
        },
        20: {
          KEY: "LEVEL_HIGH",
          VALUE: 20,
          LABEL: "紧急"
        }
      }
    },
    HOSTING_USER_ROLE: {
      DESCRIPTION: "托管机用户角色",
      ITEMS: [
        {
          KEY: "TRADER",
          VALUE: 1,
          LABEL: "交易员"
        },
        {
          KEY: "ADMIN",
          VALUE: 2,
          LABEL: "管理员"
        }
      ],
      VALUES: ["1", "2"]
    },
    M_JOB_STATUS: {
      DESCRIPTION: "信箱消息实例状态",
      ITEMS: [
        {
          KEY: "MJS_SENDING",
          VALUE: 0,
          LABEL: "发送中"
        },
        {
          KEY: "MJS_COMPLETED",
          VALUE: 1,
          LABEL: "完成"
        },
        {
          KEY: "MJS_EXCEPTION_STOP",
          VALUE: 2,
          LABEL: "异常停止"
        },
        {
          KEY: "MJS_NETWORK_ERROR_RETRY",
          VALUE: 3,
          LABEL: "错误重试中"
        },
        {
          KEY: "MJS_NETWORK_ERROR_STOP",
          VALUE: 4,
          LABEL: "网络错误停止"
        }
      ],
      VALUES: ["0", "1", "2", "3", "4"]
    }
  }
}
