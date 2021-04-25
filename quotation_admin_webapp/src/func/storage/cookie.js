export default {
  // get cookie
  getCookie(name) {
    var arr,
      reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)")
    if ((arr = document.cookie.match(reg))) return arr[2]
    else return null
  },
  // set cookie
  setCookie(key, value, expiredays, domain) {
    var exdate = new Date()
    exdate.setDate(exdate.getDate() + expiredays)
    document.cookie =
      key +
      "=" +
      escape(value) +
      (expiredays == null ? "" : ";expires=" + exdate.toGMTString()) +
      (domain == null ? "" : ";domain=" + domain)
  }
}
