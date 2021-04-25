export default {
  PROXY_ROUTER: {
    LOCALHOST: {
      HOST: "localhost:8080",
      PROXY_HOST: "https://devproxy.xueqiao.cn"
    },
    DEV: {
      HOST: "quotation.devoa.xueqiao.cn",
      PROXY_HOST: "https://devproxy.xueqiao.cn"
    },
    GAMMA: {
      HOST: "quotation.gaoa.xueqiao.cn",
      PROXY_HOST: "https://gaproxy.xueqiao.cn"
    },
    IDC: {
      HOST: "quotation.oa.xueqiao.cn",
      PROXY_HOST: "https://proxy.xueqiao.cn"
    }
  },
  ACCOUNT_PROPERTY_KEYS: {
    DESCRIPTION: "添加行情账号时附加信息的KEY",
    KEYS: [
      {
        value: "ESUNNY9_AUTHCODE",
        label: "ESUNNY9_AUTHCODE"
      },
      {
        value: "RESTART_CLOCKS",
        label: "RESTART_CLOCKS"
      }
      ,
      {
        value: "CTP_STS_APPID",
        label: "CTP_STS_APPID"
      }
      ,
      {
        value: "CTP_STS_AUTHCODE",
        label: "CTP_STS_AUTHCODE"
      }
    ]
  },
  DEPLOYMENT_SET: {
    DESCRIPTION: "部署区域",
    ITEMS: [
      {
        value: "MASTER",
        label: "MASTER"
      },
      {
        value: "SLAVE",
        label: "SLAVE"
      }
    ]
  },
  QUOTATION_PLATFORM_ENV: {
    DESCRIPTION: "行情环境",
    ITEMS: [
      {
        value: "NONE",
        label: "无"
      },
      {
        value: "REAL",
        label: "实盘"
      },
      {
        value: "SIM",
        label: "模拟盘"
      }
    ]
  },
  QUOTATION_PLATFORM_ENV_COMPACT: {
    DESCRIPTION: "行情环境紧凑版",
    ITEMS: [
      {
        value: "REAL",
        label: "实盘"
      },
      {
        value: "SIM",
        label: "模拟盘"
      }
    ]
  },
  QUOTATION_TECH_PLATFORM: {
    DESCRIPTION: "平台",
    ITEMS: [
      {
        value: "NONE",
        label: "无"
      },
      {
        value: "CTP",
        label: "CTP"
      },
      {
        value: "ESUNNY",
        label: "ESUNNY"
      },
      {
        value: "SP",
        label: "SP"
      },
      {
        value: "ESUNNY_3",
        label: "ESUNNY_3"
      }
    ]
  },
  QUOTATION_REGISTER_PRIORITY: {
    DESCRIPTION: "行情订阅优先级",
    ITEMS: [
      {
        value: "1",
        label: "1"
      },
      {
        value: "2",
        label: "2"
      },
      {
        value: "3",
        label: "3"
      }
    ]
  },
  QUOTATION_CONTRACT_COUNT: {
    DESCRIPTION: "合约展示数量",
    ITEMS: [
      {
        value: "0",
        label: "0"
      },
      {
        value: "1",
        label: "1"
      },
      {
        value: "2",
        label: "2"
      },
      {
        value: "3",
        label: "3"
      },
      {
        value: "4",
        label: "4"
      },
      {
        value: "5",
        label: "5"
      },
      {
        value: "6",
        label: "6"
      },
      {
        value: "7",
        label: "7"
      },
      {
        value: "8",
        label: "8"
      },
      {
        value: "9",
        label: "9"
      },
      {
        value: "10",
        label: "10"
      },
      {
        value: "11",
        label: "11"
      },
      {
        value: "12",
        label: "12"
      }
    ]
  },
  QUOTATION_ACCOUNT_STATE: {
    DESCRIPTION: "行情账号状态",
    ITEMS: [
      {
        value: "ACCOUNT_DISABLED",
        label: "停用"
      },
      {
        value: "ACCOUNT_ENABLED",
        label: "启用"
      }
    ]
  },
  QUOTATION_ACCOUNT_ACCESS_STATE: {
    DESCRIPTION: "行情账号接入状态",
    ITEMS: [
      {
        value: "ACCOUNT_NOT_ACCESS",
        label: "未接入"
      },
      {
        value: "ACCOUNT_ACTIVE",
        label: "正常"
      },
      {
        value: "ACCOUNT_INVALID",
        label: "异常"
      }
    ]
  },
  CONTRACT_ACTIVE_TYPE: {
    DESCRIPTION: "活跃合约类型",
    ITEMS: [
      {
        value: "ACTIVE_MONTH",
        label: "活跃月份"
      },
      {
        value: "FIXED_CODE",
        label: "固定合约号"
      }
    ]
  }
}
