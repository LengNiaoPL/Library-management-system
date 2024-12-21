function getCookie(name) {
    // 1. 将所有cookie作为一个字符串获取，并在前面加上一个分号和一个空格
    var value = "; " + document.cookie;

    // 2. 使用cookie名称作为分隔符来分割字符串
    // 例如，如果name是"username"，那么parts就是分割后的数组，形如["", "username=JohnDoe", ""]
    var parts = value.split("; " + name + "=");

    // 3. 检查分割后的数组长度是否为2
    // 如果是2，说明找到了匹配的cookie名称和值
    if (parts.length == 2) {
        // 4. 从分割后的数组中取出cookie的值部分（即第二部分）
        // 然后再次使用分号分割，以确保我们只获取cookie的值，而不是可能存在的后续cookie属性（如路径、域、过期时间等）
        return parts.pop().split(";").shift();
    }

    // 如果没有找到匹配的cookie，函数将返回undefined
}