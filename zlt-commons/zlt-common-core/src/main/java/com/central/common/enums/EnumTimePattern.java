package com.central.common.enums;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public enum EnumTimePattern {

	ddmmYYYY("^([0-9]{2})/([0-9]{2})/([0-9]{4})$", "dd/MM/yyyy", null, null),

	/**
	 * 日期格式：201904
	 */
	ym("^[0-9]{4}[0-9]{2}$", "yyyyMM", null, null),

	/**
	 * 日期格式：2019年4月
	 */
	ym_ch("^[0-9]{4}[年][0-9]{1,2}[月]$", "yyyy年M月", null, null),

	/**
	 * 日期格式：20190401
	 */
	ymd("^[0-9]{4}[0-9]{2}[0-9]{2}$", "yyyyMMdd", null, null),

	/**
	 * 日期格式：20190401131211
	 */
	ymdhms("^[0-9]{4}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}$", "yyyyMMddHHmmss", null, null),

	/**
	 * 日期格式：2019040113:12:11.556
	 */
	ymdhms_millisec("^[0-9]{4}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.[0-9]{3}$", "yyyyMMddHHmmss.SSS", null, null),

	/**
	 * 日期格式：2019-04
	 */
	y_m("^[0-9]{4}-[0-9]{2}$", "yyyy-MM", null, null),

	/**
	 * 日期格式：2019-04-01
	 */
	y_m_d("^[0-9]{4}-[0-9]{2}-[0-9]{2}$", "yyyy-MM-dd", null, null),

	/**
	 * 日期格式：2019/04
	 */
	ymdSlash("^\\d{4}/\\d{1,2}/\\d{1,2}$", "yyyy/M/dd", null, null),

	/**
	 * 日期格式：2019-04-01 17:30
	 */
	y_m_dhm("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}$", "yyyy-MM-dd HH:mm", null, null),

	/**
	 * 日期格式：2019-04-01 17:30:20
	 */
	y_m_dhms("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$", "yyyy-MM-dd HH:mm:ss", null, null),

	/**
	 * 日期格式：2019-04-01 17:30:20.556
	 */
	y_m_dhms_millisec("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}.[0-9]{3}$", "yyyy-MM-dd HH:mm:ss.SSS", null, null),

	/**
	 * 日期格式：2019-04-01T20:36:09+09:00
	 */
	utc_zone("^\\d{4}-\\d{1,2}-\\d{1,2}[T]\\d{1,2}:\\d{1,2}:\\d{1,2}[+|-]\\d{1,2}:\\d{1,2}$", "yyyy-MM-dd'T'HH:mm:ssXXX", null, "UTC"),

	/**
	 * 日期格式：2019-04-01T20:36:09.367+09:00
	 */
	utc_zone_millisec("^\\d{4}-\\d{1,2}-\\d{1,2}[T]\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d{3}[+|-]\\d{1,2}:\\d{1,2}$", "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", null, "UTC"),

	/**
	 * 日期格式：2019-04-01T20:36:09.666Z
	 */
	utc_zero("^\\d{4}-\\d{1,2}-\\d{1,2}[T]\\d{1,2}:\\d{1,2}:\\d{1,2}[Z]$", "yyyy-MM-dd'T'HH:mm:ss'Z'", null, "UTC"),
	/**
	 * 日期格式：2019-04-01T20:36Z
	 */
	utc_minute("^\\d{4}-\\d{1,2}-\\d{1,2}[T]\\d{1,2}:\\d{1,2}[Z]$", "yyyy-MM-dd'T'HH:mm'Z'", null, "UTC"),
	/**
	 * 日期格式：2019-04-01T20:36:09.666Z
	 */
	utc_zero_millisec("^\\d{4}-\\d{1,2}-\\d{1,2}[T]\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d{3}[Z]$", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", null, "UTC"),

	/**
	 * 日期格式：14.02.2019 11:38:40 UTC
	 */
	utcPoint("^\\d{1,2}.\\d{1,2}.\\d{4}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}\\s[U][T][C]$", "dd.MM.yyyy HH:mm:ss", null, "UTC"),

	/**
	 * 日期格式：2019-01-14 09:36:18 UTC
	 */
	utcBar("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}\\s[U][T][C]$", "yyyy-MM-dd HH:mm:ss", null, "UTC"),

	/**
	 * 日期格式：2018/12/31 02:08:08 UTC
	 */
	uctSlash("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}\\s[U][T][C]$", "yyyy/MM/dd HH:mm:ss", null, "UTC"),

	/**
	 * 日期格式：Feb 25, 2021 11:18:39 pm
	 */
	mdykms("^[a-zA-Z]{3} {1}\\d{1,2}[,] {1}\\d{4} {1}\\d{1,2}:\\d{1,2}:\\d{1,2} {1}[a-zA-Z]{2}$", "MMM dd, yyyy KK:mm:ss aa", Locale.ENGLISH, null),

	/**
	 * 日期格式：Feb 25, 2021, 11:18:39 pm
	 */
	mdykms2("^[a-zA-Z]{3} {1}\\d{1,2}[,] {1}\\d{4}[,] {1}\\d{1,2}:\\d{1,2}:\\d{1,2} {1}[a-zA-Z]{2}$", "MMM dd, yyyy, KK:mm:ss aa", Locale.ENGLISH, null),

	;

	EnumTimePattern(String regExp, String timePattern, Locale locale, String timeZone) {
		this.regExp = regExp;
		this.timePattern = timePattern;
		this.locale = locale;
		this.timeZone = timeZone;
	}

	private String regExp;

	private String timePattern;

	private Locale locale;

	private String timeZone;


	public Locale getLocale() {
		return this.locale;
	}

	public String getTimeZone() {
		return this.timeZone;
	}

	public String toRegExp() {
		return this.regExp;
	}

	public String toTimePattern() {
		return this.timePattern;
	}

	public String formatDate(Date date) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(this.timePattern);
			return df.format(date);
		}
		return null;
	}

	public static EnumTimePattern getTimeParttern(String time) {

		if (StringUtils.isEmpty(time)) {
			return null;
		}

		EnumTimePattern[] values = EnumTimePattern.values();

		for (EnumTimePattern value : values) {
			if (time.matches(value.toRegExp())) {
				return value;
			}
		}
		return null;
	}

	public static Date parseDate(String time) {
		if (StringUtils.isBlank(time)) {
			return null;
		}

		EnumTimePattern timePattern = getTimeParttern(time);
		if (timePattern == null) {
			throw new IllegalArgumentException("Invalid Date value '" + time + "'");
		}

		return parseDate(time, timePattern.toTimePattern(), timePattern.getLocale(), timePattern.getTimeZone());
	}

	/**
	 * 将日期字符串解析为日期时间
	 *
	 * @param dateStr     String 字符型日期
	 * @param format      String 格式
	 * @param locale      日期所属区域
	 * @param timeZoneStr 时区
	 */
	private static Date parseDate(String dateStr, String format, Locale locale, String timeZoneStr) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(format, locale == null ? Locale.getDefault(Locale.Category.FORMAT) : locale);
			if (StringUtils.isNotBlank(timeZoneStr)) {
				dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneStr));
			}
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {
			throw new RuntimeException(MessageFormat.format("报告日期{0}格式转换异常", dateStr), e);
		}
		return date;
	}


}
