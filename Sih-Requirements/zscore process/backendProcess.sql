SQL command to perfrom the functionality of zscore analysis

```sql
  -- Step 1: Calculate mean and standard deviation for the last 3 days
WITH stats AS (
    SELECT
        AVG(measurement) AS mean,
        STDDEV(measurement) AS stddev
    FROM ztest
    WHERE datetime >= NOW() - INTERVAL '3 days'
),
-- Step 2: Compute Z-Scores
zscore_calculation AS (
    SELECT
        datetime,
        measurement,
        (measurement - stats.mean) / stats.stddev AS zscore
    FROM ztest, stats
    WHERE datetime >= NOW() - INTERVAL '3 days'
)
-- Step 3: Update Z-Scores in the table
UPDATE ztest
SET zscore = zscore_calculation.zscore
FROM zscore_calculation
WHERE ztest.datetime = zscore_calculation.datetime;

```
