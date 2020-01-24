/*
 * Copyright 2012-2019 the original author or authors.
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

package org.springframework.boot.autoconfigure.data.r2dbc;

import io.r2dbc.spi.ConnectionFactory;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.boot.autoconfigure.data.RepositoryType;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactoryBean;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for Spring Data R2DBC Repositories.
 *
 * @author Mark Paluch
 * @see EnableR2dbcRepositories
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({ ConnectionFactory.class, R2dbcRepository.class })
@ConditionalOnBean(DatabaseClient.class)
@ConditionalOnRepositoryType(store = "r2dbc", type = RepositoryType.REACTIVE)
@ConditionalOnMissingBean(R2dbcRepositoryFactoryBean.class)
@Import(R2dbcRepositoriesAutoConfigureRegistrar.class)
@AutoConfigureAfter(R2dbcDataAutoConfiguration.class)
public class R2dbcRepositoriesAutoConfiguration {

}
