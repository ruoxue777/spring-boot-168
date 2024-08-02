package org.ruoxue.spring_boot_168.config.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@Configuration
@ConfigurationProperties("global-setting")
//@RefreshScope
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GlobalSetting {

	private static final Gson gson = new Gson();

	/** json 內容 */
	private String json;

	/** 預設每頁筆數 */
	private int defaultPageSize;

	// --------------------------------------------------------
	// JWT
	// --------------------------------------------------------
	/** token 密鑰 */
	private String tokenSecret;

	/** 到期毫秒 */
	private long expireTime;

	/** 刷新到期毫秒 */
	private long refreshExpireTime;

	/** 發行者 */
	private String issuer;

	public void setJson(String json) {
		this.json = json;
		GlobalSetting setting = fromJson(json);
		this.setDefaultPageSize(setting.getDefaultPageSize());
		this.setTokenSecret(setting.getTokenSecret());
		this.setExpireTime(setting.getExpireTime());
		this.setRefreshExpireTime(setting.getRefreshExpireTime());
		this.setIssuer(setting.getIssuer());
	}

	public static GlobalSetting fromJson(String json) {
		GlobalSetting result = null;
		if (json != null && !json.equals("")) {
			result = gson.fromJson(json, GlobalSetting.class);
		}
		return result;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		builder.appendSuper(super.toString());
		builder.append("defaultPageSize", defaultPageSize);

		builder.append("tokenSecret", tokenSecret);
		builder.append("expireTime", expireTime);
		builder.append("refreshExpireTime", refreshExpireTime);
		builder.append("issuer", issuer);
		return builder.toString();
	}
}
