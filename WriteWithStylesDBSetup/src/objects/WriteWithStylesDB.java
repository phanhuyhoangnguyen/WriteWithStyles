/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 101042618
 */
public class WriteWithStylesDB {

    // Database parameters for connection - url, username, password
    static String url;
    static String username;
    static String password;

    private final String DB_GROUP_TABLE = "REALMGROUP";
    private final String DB_GROUP_TABLE_GROUPID_COL = "GroupId";
    private final String DB_GROUP_TABLE_NAME_COL = "GroupName";

    private final String DB_PRODUCTCATEGORY_TABLE = "PRODUCTCATEGORY";
    private final String DB_PRODUCTCATEGORY_TABLE_PRODUCTCATEGORYID_COL = "ProductCategoryId";
    private final String DB_PRODUCTCATEGORY_TABLE_NAME_COL = "Name";

    private final String DB_PRODUCT_TABLE = "PRODUCT";
    private final String DB_PRODUCT_TABLE_PRODUCTID_COL = "ProductId";
    private final String DB_PRODUCT_TABLE_NAME_COL = "Name";
    private final String DB_PRODUCT_TABLE_BRAND_COL = "Brand";
    private final String DB_PRODUCT_TABLE_DESC_COL = "Description";
    private final String DB_PRODUCT_TABLE_PRICE_COL = "Price";
    private final String DB_PRODUCT_TABLE_COLOUR_COL = "Colour";
    private final String DB_PRODUCT_TABLE_IMG_COL = "Image";
    private final String DB_PRODUCT_TABLE_SOLDQN_COL = "SoldQuantity";

    private final String DB_INVENTORY_TABLE = "INVENTORY";
    private final String DB_INVENTORY_TABLE_INVENTORYID_COL = "InventoryId";
    private final String DB_INVENTORY_TABLE_STOCKQN_COL = "StockQuantity";
    private final String DB_INVENTORY_TABLE_DATE_ADDED_COL = "DateAdded";

    private final String DB_CUSTOMERORDER_TABLE = "CUSTOMERORDER";
    private final String DB_CUSTOMERORDER_TABLE_ORDERID_COL = "OrderId";
    private final String DB_CUSTOMERORDER_TABLE_CUSTFNAME_COL = "FirstName";
    private final String DB_CUSTOMERORDER_TABLE_CUSTLNAME_COL = "LastName";
    private final String DB_CUSTOMERORDER_TABLE_EMAIL_COL = "Email";
    private final String DB_CUSTOMERORDER_TABLE_MOBILE_COL = "Mobile";
    private final String DB_CUSTOMERORDER_TABLE_DELADD_COL = "DeliveryAddress";
    private final String DB_CUSTOMERORDER_TABLE_SUBURB_COL = "Suburb";
    private final String DB_CUSTOMERORDER_TABLE_POSTCODE_COL = "PostCode";
    private final String DB_CUSTOMERORDER_TABLE_STATE_COL = "State";
    private final String DB_CUSTOMERORDER_TABLE_CREDITCARDNO_COL = "CreditCardNo";
    private final String DB_CUSTOMERORDER_TABLE_CUSTID_COL = "UserId";

    private final String DB_CUSTOMERORDERPRODUCT_TABLE = "CUSTOMERORDERPRODUCT";
    private final String DB_CUSTOMERORDERPRODUCT_TABLE_ORDEREDQN_COL = "OrderedQuantity";
    private final String DB_CUSTOMERORDERPRODUCT_TABLE_PRODCUTPRICE_COL = "ProductPrice";

    private final String DB_USER_TABLE = "APPUSER";
    private final String DB_USER_TABLE_USERID_COL = "UserId";
    private final String DB_USER_TABLE_CUSTFNAME_COL = "FirstName";
    private final String DB_USER_TABLE_CUSTLNAME_COL = "LastName";
    private final String DB_USER_TABLE_EMAIL_COL = "Email";
    private final String DB_USER_TABLE_PASSWORD_COL = "Password";
    private final String DB_USER_TABLE_MOBILE_COL = "Mobile";
    private final String DB_USER_TABLE_ADD_COL = "Address";
    private final String DB_USER_TABLE_SUBURB_COL = "Suburb";
    private final String DB_USER_TABLE_POSTCODE_COL = "PostCode";
    private final String DB_USER_TABLE_STATE_COL = "State";
    private final String DB_USER_TABLE_CREDITCARDHOLDERNAME_COL = "CreditCardHolderName";
    private final String DB_USER_TABLE_CREDITCARDNO_COL = "CreditCardNo";
    private final String DB_USER_TABLE_CREDITCARDEXPMONTH_COL = "CreditCardExpMonth";
    private final String DB_USER_TABLE_CREDITCARDEXPYEAR_COL = "creditCardExpYear";
    private final String DB_USER_TABLE_CREDITCARDCCVNO_COL = "CCVNumber";

    private final String DB_USERGROUP_TABLE = "USERGROUP";
    private final String DB_USERGROUP_VIEW = "V_USERGROUP";

    /**
     * constructor using default url, username and password
     */
    public WriteWithStylesDB() {
        // set default parameters for Derby and JavaDB
        url = "jdbc:derby://localhost:1527/WriteWithStyles;create=true";
        username = "APP";
        password = "APP";
    }

    /**
     * getConnecion()
     *
     * @aim Get a connection to the database using the specified info
     */
    public static Connection getConnection()
            throws SQLException, IOException {
        // first, need to set the driver for connection
        // for Derby
        System.setProperty("jdbc.drivers",
                "org.apache.derby.jdbc.ClientDriver");

        // next is to get the connection
        return DriverManager.getConnection(url, username, password);
    }

    public void createDBTables() {
        String createGroupDBTableSql = "CREATE TABLE " + DB_GROUP_TABLE
                + "(" + DB_GROUP_TABLE_GROUPID_COL + " INT GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_" + DB_GROUP_TABLE + " PRIMARY KEY, "
                + DB_GROUP_TABLE_NAME_COL + " VARCHAR(75))";
        createDBTable(createGroupDBTableSql);

        String createCategoryDBTableSql = "CREATE TABLE " + DB_PRODUCTCATEGORY_TABLE
                + "(" + DB_PRODUCTCATEGORY_TABLE_PRODUCTCATEGORYID_COL + " INT GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_" + DB_PRODUCTCATEGORY_TABLE + " PRIMARY KEY, "
                + DB_PRODUCTCATEGORY_TABLE_NAME_COL + " VARCHAR(75))";
        createDBTable(createCategoryDBTableSql);

        String createProductDBTableSql = "CREATE TABLE " + DB_PRODUCT_TABLE + " "
                + "(" + DB_PRODUCT_TABLE_PRODUCTID_COL + " INT GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_" + DB_PRODUCT_TABLE + " PRIMARY KEY, "
                + DB_PRODUCT_TABLE_NAME_COL + " VARCHAR(50), "
                + DB_PRODUCT_TABLE_BRAND_COL + " CHAR(50), "
                + DB_PRODUCT_TABLE_DESC_COL + " LONG VARCHAR, "
                + DB_PRODUCT_TABLE_PRICE_COL + " REAL, "
                + DB_PRODUCT_TABLE_COLOUR_COL + " CHAR(25), "
                + DB_PRODUCT_TABLE_IMG_COL + " VARCHAR(100), "
                + DB_PRODUCT_TABLE_SOLDQN_COL + " INT, "
                + DB_PRODUCTCATEGORY_TABLE_PRODUCTCATEGORYID_COL + " INT references " + DB_PRODUCTCATEGORY_TABLE + " (" + DB_PRODUCTCATEGORY_TABLE_PRODUCTCATEGORYID_COL + "))";
        createDBTable(createProductDBTableSql);

        String createInventoryDBTableSql = "CREATE TABLE " + DB_INVENTORY_TABLE + " "
                + "(" + DB_INVENTORY_TABLE_INVENTORYID_COL + " INT GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_" + DB_INVENTORY_TABLE + " PRIMARY KEY, "
                + DB_PRODUCT_TABLE_PRODUCTID_COL + " INT references " + DB_PRODUCT_TABLE + " (" + DB_PRODUCT_TABLE_PRODUCTID_COL + ") CONSTRAINT UC_" + DB_INVENTORY_TABLE + " UNIQUE , "
                + DB_INVENTORY_TABLE_STOCKQN_COL + " INT, "
                + DB_INVENTORY_TABLE_DATE_ADDED_COL + " Timestamp)";
        createDBTable(createInventoryDBTableSql);

        String createCustomerOrderDBTableSql = "CREATE TABLE " + DB_CUSTOMERORDER_TABLE
                + " (" + DB_CUSTOMERORDER_TABLE_ORDERID_COL + " INT GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_" + DB_CUSTOMERORDER_TABLE + " PRIMARY KEY, "
                + DB_CUSTOMERORDER_TABLE_CUSTFNAME_COL + " VARCHAR(50), "
                + DB_CUSTOMERORDER_TABLE_CUSTLNAME_COL + " VARCHAR(50), "
                + DB_CUSTOMERORDER_TABLE_EMAIL_COL + " VARCHAR(255), "
                + DB_CUSTOMERORDER_TABLE_MOBILE_COL + " VARCHAR(20), "
                + DB_CUSTOMERORDER_TABLE_DELADD_COL + " VARCHAR(50), "
                + DB_CUSTOMERORDER_TABLE_SUBURB_COL + " VARCHAR(50), "
                + DB_CUSTOMERORDER_TABLE_POSTCODE_COL + " VARCHAR(10), "
                + DB_CUSTOMERORDER_TABLE_STATE_COL + " VARCHAR(30), "
                + DB_CUSTOMERORDER_TABLE_CREDITCARDNO_COL + " VARCHAR(64), "
                + DB_CUSTOMERORDER_TABLE_CUSTID_COL + " INT)";
        createDBTable(createCustomerOrderDBTableSql);

        String createCustomerOrderProductDBTableSql = "CREATE TABLE " + DB_CUSTOMERORDERPRODUCT_TABLE
                + " (" + DB_CUSTOMERORDER_TABLE_ORDERID_COL + " INT references " + DB_CUSTOMERORDER_TABLE + " (" + DB_CUSTOMERORDER_TABLE_ORDERID_COL + "), "
                + DB_PRODUCT_TABLE_PRODUCTID_COL + " INT references " + DB_PRODUCT_TABLE + " (" + DB_PRODUCT_TABLE_PRODUCTID_COL + "), "
                + DB_CUSTOMERORDERPRODUCT_TABLE_ORDEREDQN_COL + " INT, "
                + DB_CUSTOMERORDERPRODUCT_TABLE_PRODCUTPRICE_COL + " REAL, "
                + "PRIMARY KEY " + "(" + DB_CUSTOMERORDER_TABLE_ORDERID_COL + ", " + DB_PRODUCT_TABLE_PRODUCTID_COL + "))";
        createDBTable(createCustomerOrderProductDBTableSql);

        String createUserDBTableSql = "CREATE TABLE " + DB_USER_TABLE
                + " (" + DB_USER_TABLE_USERID_COL + " INT GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_" + DB_USER_TABLE + " PRIMARY KEY, "
                + DB_USER_TABLE_CUSTFNAME_COL + " VARCHAR(50), "
                + DB_USER_TABLE_CUSTLNAME_COL + " VARCHAR(50), "
                + DB_USER_TABLE_EMAIL_COL + " VARCHAR(255) CONSTRAINT UC_" + DB_USER_TABLE + " UNIQUE, "
                + DB_USER_TABLE_PASSWORD_COL + " VARCHAR(64), "
                + DB_USER_TABLE_MOBILE_COL + " VARCHAR(20), "
                + DB_USER_TABLE_ADD_COL + " VARCHAR(50), "
                + DB_USER_TABLE_SUBURB_COL + " VARCHAR(50), "
                + DB_USER_TABLE_POSTCODE_COL + " VARCHAR(10), "
                + DB_USER_TABLE_STATE_COL + " VARCHAR(30))";
        createDBTable(createUserDBTableSql);

        String createUserGroupDBTableSql = "CREATE TABLE " + DB_USERGROUP_TABLE
                + " (" + DB_USER_TABLE_USERID_COL + " INT references " + DB_USER_TABLE + " (" + DB_USER_TABLE_USERID_COL + "), "
                + DB_GROUP_TABLE_GROUPID_COL + " INT references " + DB_GROUP_TABLE + " (" + DB_GROUP_TABLE_GROUPID_COL + "), "
                + "PRIMARY KEY " + "(" + DB_USER_TABLE_USERID_COL + ", " + DB_GROUP_TABLE_GROUPID_COL + "))";
        createDBTable(createUserGroupDBTableSql);

        String createUserGroupViewSql = "CREATE VIEW " + DB_USERGROUP_VIEW + " AS "
                + "SELECT " + DB_USER_TABLE + "." + DB_USER_TABLE_EMAIL_COL + ", " + DB_USER_TABLE + "." + DB_USER_TABLE_PASSWORD_COL + ", " + DB_GROUP_TABLE + "." + DB_GROUP_TABLE_NAME_COL + " "
                + "FROM " + DB_USERGROUP_TABLE + " "
                + "INNER JOIN " + DB_USER_TABLE + " "
                + "ON " + DB_USER_TABLE + "." + DB_USER_TABLE_USERID_COL + " = " + DB_USERGROUP_TABLE + "." + DB_USER_TABLE_USERID_COL + " "
                + "INNER JOIN " + DB_GROUP_TABLE + " "
                + "ON " + DB_GROUP_TABLE + "." + DB_GROUP_TABLE_GROUPID_COL + " = " + DB_USERGROUP_TABLE + "." + DB_GROUP_TABLE_GROUPID_COL;
        createDBTable(createUserGroupViewSql);
    }

    /*
     * createDBTable
     *
     * @aim Use SQL commands to create the database table
     */
    public void createDBTable(String createTableSql) {
        Connection cnnct = null;    // declare a connection object
        Statement stmnt = null;     // declare a statement object

        try {
            // get connection
            cnnct = getConnection();
            // get statement
            stmnt = cnnct.createStatement();
            stmnt.execute(createTableSql);
        } catch (SQLException ex) {
            System.out.println(ex);
            // do nothing
        } catch (IOException ex) {
            System.out.println(ex);
            // do nothing
        } finally {
            // close Statement object
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    /**
                     * cnnct.close() throws a SQLException, but we cannot
                     * recover at this point
                     */
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }

    /**
     * destroyDBTable()
     *
     * @aim Remove the database table
     */
    public void destroyDBTables() {
        destroyView(DB_USERGROUP_VIEW);
        destroyDBTable(DB_USERGROUP_TABLE);
        destroyDBTable(DB_USER_TABLE);
        destroyDBTable(DB_GROUP_TABLE);
        destroyDBTable(DB_CUSTOMERORDERPRODUCT_TABLE);
        destroyDBTable(DB_CUSTOMERORDER_TABLE);
        destroyDBTable(DB_INVENTORY_TABLE);
        destroyDBTable(DB_PRODUCT_TABLE);
        destroyDBTable(DB_PRODUCTCATEGORY_TABLE);
    }

    public void destroyDBTable(String tableName) {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            // get connection
            cnnct = getConnection();
            // get statement
            stmnt = cnnct.createStatement();

            // execute action query to destroy a data table
            stmnt.execute("DROP TABLE " + tableName);
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            // do nothing
        } finally {
            // close Statement object
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }

    public void destroyView(String viewName) {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            // get connection
            cnnct = getConnection();
            // get statement
            stmnt = cnnct.createStatement();

            // execute action query to destroy a data table
            stmnt.execute("DROP VIEW " + viewName);
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            // do nothing
        } finally {
            // close Statement object
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }

    public void addRecordsToProductTable(ArrayList<Product> productList) {
        Connection cnnct = null;
        // create a PreparedStatement object
        PreparedStatement pStmnt = null;

        try {
            // get connection
            cnnct = getConnection();

            // precompiled query statement
            String preQueryStatement = "INSERT INTO " + DB_PRODUCT_TABLE + "("
                    + DB_PRODUCT_TABLE_NAME_COL + ", "
                    + DB_PRODUCT_TABLE_BRAND_COL + ", "
                    + DB_PRODUCT_TABLE_DESC_COL + ", "
                    + DB_PRODUCT_TABLE_PRICE_COL + ", "
                    + DB_PRODUCT_TABLE_COLOUR_COL + ", "
                    + DB_PRODUCT_TABLE_IMG_COL + ", "
                    + DB_PRODUCT_TABLE_SOLDQN_COL + ", "
                    + DB_PRODUCTCATEGORY_TABLE_PRODUCTCATEGORYID_COL + ")"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            for (Product product : productList) {

                // get statement
                pStmnt = cnnct.prepareStatement(preQueryStatement);

                // set individual parameters at corresponding positions
                pStmnt.setString(1, product.getName());
                pStmnt.setString(2, product.getBrand());
                pStmnt.setString(3, product.getDescription());
                pStmnt.setDouble(4, product.getPrice());
                pStmnt.setString(5, product.getColour());
                pStmnt.setString(6, product.getImage());
                pStmnt.setInt(7, product.getSoldQuantity());
                pStmnt.setInt(8, product.getProductCategoryId());

                int rowCount = pStmnt.executeUpdate();

                if (rowCount == 0) {
                    throw new SQLException("Cannot insert records!");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            // do nothing
        } finally {
            // close Prepared Statement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }

    public void addRecordsToGroupTable(ArrayList<Group> groupList) {
        Connection cnnct = null;
        // create a PreparedStatement object
        PreparedStatement pStmnt = null;

        try {
            // get connection
            cnnct = getConnection();
            // precompiled query statement
            String preQueryStatement = "INSERT INTO " + DB_GROUP_TABLE + "("
                    + DB_GROUP_TABLE_NAME_COL + ") "
                    + "VALUES (?)";

            for (Group group : groupList) {

                // get statement
                pStmnt = cnnct.prepareStatement(preQueryStatement);

                // set individual parameters at corresponding positions
                pStmnt.setString(1, group.getName());

                int rowCount = pStmnt.executeUpdate();

                if (rowCount == 0) {
                    throw new SQLException("Cannot insert records!");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            // do nothing
        } finally {
            // close Prepared Statement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }

    public void addRecordsToProductCategoryTable(ArrayList<ProductCategory> categoryList) {
        Connection cnnct = null;
        // create a PreparedStatement object
        PreparedStatement pStmnt = null;

        try {
            // get connection
            cnnct = getConnection();
            // precompiled query statement
            String preQueryStatement = "INSERT INTO " + DB_PRODUCTCATEGORY_TABLE + "("
                    + DB_PRODUCTCATEGORY_TABLE_NAME_COL + ") "
                    + "VALUES (?)";

            for (ProductCategory category : categoryList) {

                // get statement
                pStmnt = cnnct.prepareStatement(preQueryStatement);

                // set individual parameters at corresponding positions
                pStmnt.setString(1, category.getName());

                int rowCount = pStmnt.executeUpdate();

                if (rowCount == 0) {
                    throw new SQLException("Cannot insert records!");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            // do nothing
        } finally {
            // close Prepared Statement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }

    public void addRecordsToInventoryTable(ArrayList<Product> productList) {

        Connection cnnct = null;

        // create a PreparedStatement object
        PreparedStatement pStmnt = null;

        try {
            // get connection
            cnnct = getConnection();

            // precompiled query statement
            String preQueryStatement = "INSERT INTO " + DB_INVENTORY_TABLE + "("
                    + DB_PRODUCT_TABLE_PRODUCTID_COL + ", "
                    + DB_INVENTORY_TABLE_STOCKQN_COL + ", "
                    + DB_INVENTORY_TABLE_DATE_ADDED_COL + ")"
                    + " VALUES (?, ?, ?)";

            for (Product product : productList) {

                // get statement
                pStmnt = cnnct.prepareStatement(preQueryStatement);

                // set individual parameters at corresponding positions
                pStmnt.setInt(1, product.getId());
                pStmnt.setInt(2, product.getQuantity());
                pStmnt.setTimestamp(3, new java.sql.Timestamp(product.getDateAdded().getTime()));

                int rowCount = pStmnt.executeUpdate();

                if (rowCount == 0) {
                    throw new SQLException("Cannot insert records!");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            // do nothing
        } finally {
            // close Prepared Statement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }
}
