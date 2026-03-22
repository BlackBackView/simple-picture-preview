package com.pic.preview.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * 字符串工具类
 */
object EasyStringUtils {
    
    /**
     * 检查字符串是否为空或null
     */
    fun isEmpty(str: String?): Boolean {
        return str == null || str.trim().isEmpty()
    }
    
    /**
     * 检查字符串是否不为空
     */
    fun isNotEmpty(str: String?): Boolean {
        return !isEmpty(str)
    }
    
    /**
     * 格式化时间戳为字符串
     */
    fun formatTimestamp(timestamp: Long, pattern: String = "yyyy-MM-dd HH:mm:ss"): String {
        return try {
            val sdf = SimpleDateFormat(pattern, Locale.getDefault())
            sdf.format(Date(timestamp))
        } catch (e: Exception) {
            ""
        }
    }
    
    /**
     * 截取字符串，超过长度则添加省略号
     */
    fun truncateWithEllipsis(text: String, maxLength: Int): String {
        return if (text.length > maxLength) {
            text.substring(0, maxLength) + "..."
        } else {
            text
        }
    }
    
    /**
     * 将字符串转换为驼峰命名
     */
    fun toCamelCase(text: String): String {
        return text.split("_", "-", " ")
            .mapIndexed { index, word ->
                if (index == 0) {
                    word.lowercase()
                } else {
                    word.replaceFirstChar { it.uppercase() }
                }
            }
            .joinToString("")
    }
    
    /**
     * 检查字符串是否为数字
     */
    fun isNumeric(str: String): Boolean {
        return str.matches(Regex("\\d+"))
    }
    
    /**
     * 检查字符串是否为邮箱格式
     */
    fun isEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
        return email.matches(Regex(emailRegex))
    }
    
    /**
     * 检查字符串是否为手机号
     */
    fun isPhoneNumber(phone: String): Boolean {
        return phone.matches(Regex("^1[3-9]\\d{9}$"))
    }
}