# Covid Analytics

This application is giving a India analytics based on the data 
provided from the apis. This application is using api https://api.apify.com,
Based on the live data provided every day currently it is generating DF. 

## Background

In recent days, Due to increasing number of corona cases, Users may be not
aware of actual number of active cases in India, This code will help any developer 
to get active number of cases summary. Also, Gives a basic idea of Scala and Apache Spark strcutures. 

## Table of content

- [Covid Analytics](#covid-analytics)
  * [Background](#background)
  * [Install](#install)
  * [Follow for JDK Installation](#follow-for-jdk-installation)
  * [Prerequisites](#prerequisites)
  * [Installing the Default JRE/JDK](#installing-the-default-jre-jdk)
  * [Installing the Oracle JDK](#installing-the-oracle-jdk)
    + [Oracle JDK 8](#oracle-jdk-8)
  * [Usage](#usage)
    + [State wise data frame](#state-wise-data-frame)
    + [Date wise number of active cases](#date-wise-number-of-active-cases)
  * [Maintainers](#maintainers)
  * [Contributing](#contributing)
  * [License](#license)

## Install

For installation this project you need a local system with JDK 8
 installed & IDE (IntelliJ Idea preferred) You may get help as below
 
You can download IntelliJ Idea from below link
https://www.jetbrains.com/idea/

## Follow for JDK Installation

This will guide you for JDK installation on Linux based platform. 

## Prerequisites

To follow this tutorial, you will need:

## Installing the Default JRE/JDK

The easiest option for installing Java is using the version packaged with Ubuntu. Specifically, this will install OpenJDK 8, the latest and recommended version.

First, update the package index.

Next, install Java. Specifically, this command will install the Java Runtime Environment (JRE).

    sudo apt-get install default-jre

There is another default Java installation called the JDK (Java Development Kit). The JDK is usually only needed if you are going to compile Java programs or if the software that will use Java specifically requires it.

The JDK does contain the JRE, so there are no disadvantages if you install the JDK instead of the JRE, except for the larger file size.

You can install the JDK with the following command:

    sudo apt-get install default-jdk

## Installing the Oracle JDK

If you want to install the Oracle JDK, which is the official version distributed by Oracle, you will need to follow a few more steps. If you need Java 6 or 7, which are not available in the default Ubuntu 16.04 repositories (not recommended), this installation method is also available.

First, add Oracle's PPA, then update your package repository.

    sudo add-apt-repository ppa:webupd8team/java
    sudo apt-get update

Then, depending on the version you want to install, execute one of the following commands:

### Oracle JDK 8

This is the latest stable version of Java at time of writing, and the recommended version to install. You can do so using the following command:

    sudo apt-get install oracle-java8-installer 

## Usage 

For getting interactive analytics import project in IDE and just tap on Run Button. 

### State wise data frame

In this data frame we can get basic ideas about the state wise active COVID-19 cases. 

```
+--------------------+-------------+---------+--------+
|              region|totalInfected|recovered|deceased|
+--------------------+-------------+---------+--------+
|Andaman and Nicob...|          726|      530|       0|
|      Andhra Pradesh|        35447|    11823|     777|
|   Arunachal Pradesh|           22|       22|       0|
|               Assam|         1018|      689|      25|
|               Bihar|        11021|     3371|      79|
|          Chandigarh|         2170|      425|      12|
|        Chhattisgarh|         1087|      827|       0|
|  Dadar Nagar Haveli|            7|        0|       0|
|               Delhi|       102297|    31233|    1385|
|                 Goa|          154|      154|       0|
|             Gujarat|       122697|    25375|    6728|
|             Haryana|        10093|     5351|     117|
|    Himachal Pradesh|          949|      718|      29|
|   Jammu and Kashmir|        15306|     6085|     182|
|           Jharkhand|         2652|      713|      66|
|           Karnataka|        14139|     6518|     559|
|              Kerala|        10994|     9267|      88|
|              Ladakh|          716|      375|       0|
|      Madhya Pradesh|        62349|    18387|    3454|
|     Madhya Pradesh#|         2561|      377|    null|
|         Maharashtra|       307714|    53668|   12487|
|             Manipur|           44|       44|       0|
|           Meghalaya|          267|       80|      22|
|             Mizoram|           22|        3|       0|
|              Odisha|         4136|     1193|      30|
|          Puducherry|          187|      112|       0|
|              Punjab|        21699|     2561|     502|
|           Rajasthan|        65115|    28653|    1633|
|          Tamil Nadu|        81167|    31399|     710|
|           Telengana|        23804|    11468|     612|
|             Tripura|          821|       44|       0|
|       Uttar Pradesh|        58676|    19162|    1101|
|         Uttarakhand|         1312|      855|      10|
|         West Bengal|        25043|     4965|    1796|
+--------------------+-------------+---------+--------+
``` 

### Date wise number of active cases 

You can get details for INDIA, Date wise number of active cases.

```$xslt
+-----------+---------+------+----------+------------------+
|activeCases|recovered|deaths|totalCases|lastUpdatedAtApify|
+-----------+---------+------+----------+------------------+
|      46008|    22454|  2293|     70755|        12/05/2020|
|      44029|    20916|  2206|     67151|        11/05/2020|
|      41472|    19357|  2109|     62938|        10/05/2020|
|      39834|    17846|  1981|     59661|        09/05/2020|
|      37916|    16539|  1886|     56341|        08/05/2020|
|      35902|    15266|  1783|     52951|        07/05/2020|
|      33514|    14182|  1694|     49390|        06/05/2020|
|      32138|    12726|  1568|     46432|        05/05/2020|
|      31967|    13160|  1583|     46710|        05/05/2020|
|      29685|    11761|  1389|     42835|        04/05/2020|
|      29453|    11706|  1373|     42532|        04/05/2020|
|      28070|    10886|  1306|     40262|        03/05/2020|
|      28046|    10632|  1301|     39979|        03/05/2020|
|      26535|    10017|  1223|     37775|        02/05/2020|
|      26167|     9950|  1218|     37335|        02/05/2020|
|      25148|     9064|  1152|     35364|        01/05/2020|
|      25007|     8888|  1147|     35042|        01/05/2020|
|      25007|     8888|  1147|     35042|        01/05/2020|
|      24162|     8372|  1075|     33609|        30/04/2020|
|      23651|     8324|  1074|     33049|        30/04/2020|
|      22982|     7796|  1008|     31786|        29/04/2020|
|      22629|     7695|  1007|     31331|        29/04/2020|
+-----------+---------+------+----------+------------------+
```

## Maintainers

[@iamjayantchauhan](https://github.com/iamjayantchauhan).

## Contributing

Feel free to dive in! [Open an issue](https://github.com/iamjayantchauhan/CovidAnalytics/issues/new) or submit PRs.

Standard Readme follows the [Contributor Covenant](http://contributor-covenant.org/version/1/3/0/) Code of Conduct.

## License

[MIT](LICENSE) © Jayant Chauhan