/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.data.client.immutable;


import org.opensearch.data.client.junit.jupiter.OpenSearchRestTemplateConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.immutable.ImmutableRepositoryIntegrationTests;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.utils.IndexNameProvider;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ImmutableRepositoryORHLCIntegrationTests.Config.class)
public class ImmutableRepositoryORHLCIntegrationTests extends ImmutableRepositoryIntegrationTests {

    @Configuration
    @Import({OpenSearchRestTemplateConfiguration.class})
    @EnableElasticsearchRepositories(
            basePackages = {"org.springframework.data.elasticsearch.immutable"},
            considerNestedRepositories = true)
    static class Config {
        @Bean
        IndexNameProvider indexNameProvider() {
            return new IndexNameProvider("immutable-os");
        }
    }
}
