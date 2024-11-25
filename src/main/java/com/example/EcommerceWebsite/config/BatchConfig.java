package com.example.EcommerceWebsite.config;

import com.example.EcommerceWebsite.model.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Bean
    public Job jobBean(JobRepository jobRepository, JobListener listener, Step steps) {

        return new JobBuilder("myjob", jobRepository).listener(listener).start(steps).build();

    }

    @Bean
    public Step steps(
            JobRepository jobRepository,
            DataSourceTransactionManager transactionManager,
            FlatFileItemReader<Product> reader,
            ItemProcessor<Product, Product> itemProcessor,
            ItemWriter<Product> itemWriter

    ) {
        return new StepBuilder("jobStep", jobRepository)
                .<Product, Product>chunk(5, transactionManager)
                .reader(reader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

//    @Bean
//    public FlatFileItemReader<Product> reader() {  // FlatFileItemReader is used to read data from csv files
//        return new FlatFileItemReaderBuilder<Product>()
//                .name("reader")   // reader is used for logging or monitoring purpose
//                .resource(new ClassPathResource("products.csv"))
//                .delimited()     //   .delimited().names(...): Specifies the columns in the CSV file and maps them to fields in Product.
//                .names("id", "name", "price", "brandName", "mainCategory", "subCategory", "manufacturingDate", "expiryDate")
//                .targetType(Product.class)
//                .build();
//
//    }

    @Bean
    public FlatFileItemReader<Product> reader() {
        return new FlatFileItemReaderBuilder<Product>()
                .name("reader")
                .resource(new ClassPathResource("products.csv"))
                .delimited()
                .names("id", "name", "price", "brandName", "mainCategory", "subCategory", "manufacturingDate", "expiryDate")
                .fieldSetMapper(new ProductFieldSetMapper()) // Use the custom mapper
                .build();
    }


    @Bean
    public ItemProcessor<Product, Product> itemProcessor() {
        return new CustomItemProcessor();
    }

    @Bean
    public ItemWriter<Product> itemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Product>()
                .sql("INSERT INTO product (id, name, price, brand_name, main_category, sub_category, manufacturing_date, expiry_date) " +
                        "VALUES (:id, :name, :price, :brandName, :mainCategory, :subCategory, :manufacturingDate, :expiryDate)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public FormattingConversionService conversionService() {
        FormattingConversionService conversionService = new FormattingConversionService();
        conversionService.addConverter(new StringToLocalDateConverter());
        return conversionService;
    }

}

