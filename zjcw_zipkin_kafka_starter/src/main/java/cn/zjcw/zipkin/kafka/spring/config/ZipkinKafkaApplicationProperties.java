/*
 * Copyright 2012-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.zjcw.zipkin.kafka.spring.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Arvin
 * @since 2022-04-13
 */
@Configuration
@EnableApolloConfig(value = {"application"}, order = 2)
@ConfigurationProperties(prefix = "cn.zjcw.zipkin.kafka")
public class ZipkinKafkaApplicationProperties {

	/**
	 * JSON 格式配置 tag
	 * {
	 *     "version": "1.0.0",
	 *     "bus": "zj"
	 * }
	 */
	private String tags;

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
