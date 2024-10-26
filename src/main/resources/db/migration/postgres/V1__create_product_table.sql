CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,                  -- Auto-incrementing primary key in PostgreSQL using Serial
    name VARCHAR(255) NOT NULL,             -- Product name (required)
    price DECIMAL(10, 2) NOT NULL,          -- Product price with 2 decimal places
    brand_name VARCHAR(255),                -- Optional brand name
    main_category VARCHAR(255),             -- Optional main category
    sub_category VARCHAR(255),              -- Optional sub-category
    expiry_date DATE,                       -- Expiry date of the product (optional)
    manufacturing_date DATE                 -- Manufacturing date of the product (optional)
);
