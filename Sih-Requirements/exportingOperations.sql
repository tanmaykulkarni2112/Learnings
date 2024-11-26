--clean up the file using pandas

-- Might need to change the 
SHOW datestyle;
SET datestyle = 'MDY';0 --OR othe format
RESET datestyle;


-- Staging table 
CREATE TABLE staging_table (
    agency_cd TEXT,
    site_no TEXT,
    datetime TIMESTAMP,
    tz_cd TEXT,
    measurement NUMERIC,
    measurement_cd TEXT
);

-- Importing csv to staging table
COPY staging_table (agency_cd, site_no, datetime, tz_cd, measurement, measurement_cd)
FROM '/path/to/your/file.csv'  -- Replace with your actual file path
DELIMITER ',' CSV HEADER;

-- Schema final Table
CREATE TABLE final_table (
    agency_cd TEXT,
    site_no TEXT,
    datetime TIMESTAMP,
    tz_cd TEXT,
    measurement NUMERIC,
    measurement_cd TEXT
);


-- Filter data inside final table
INSERT INTO final_table (agency_cd, site_no, datetime, tz_cd, measurement, measurement_cd)
SELECT 
    agency_cd, 
    site_no, 
    datetime, 
    tz_cd, 
    measurement, 
    measurement_cd
FROM 
    staging_table
WHERE 
    EXTRACT(YEAR FROM datetime) >= 2017  -- From 2017 onwards
    AND EXTRACT(MINUTE FROM datetime) = 0  -- Exact hour mark
    AND EXTRACT(SECOND FROM datetime) = 0;  -- Exact hour mark

