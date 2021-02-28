/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writewithstylesdbsetup;

import java.text.ParseException;
import java.util.ArrayList;
import objects.Group;
import objects.Product;
import objects.ProductCategory;
import objects.WriteWithStylesDB;

/**
 *
 * @author 101042618
 */
public class WriteWithStylesDBSetup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        WriteWithStylesDB db = new WriteWithStylesDB();

        // make sure no name conflicts
        try {
            System.out.println("Delete existing tables");
            db.destroyDBTables();
        } catch (Exception ex) {
        }

        // create the database table
        System.out.println("Create an empty database tables");
        db.createDBTables();

        System.out.println("Add several static records in the database table");

        // prepare product category data
        ProductCategory productCategory1 = new ProductCategory(1, "Fountain Pen");
        ProductCategory productCategory2 = new ProductCategory(2, "Rollerball Pen");
        ProductCategory productCategory3 = new ProductCategory(3, "Ballpoint Pen");
        ProductCategory productCategory4 = new ProductCategory(4, "Accessories");

        ArrayList<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(productCategory1);
        productCategoryList.add(productCategory2);
        productCategoryList.add(productCategory3);
        productCategoryList.add(productCategory4);

        // prepare product data
        Product product1 = new Product(
                1,
                "Classic Skyline",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                44.95,
                "Black",
                "kw-10000000_r.01.jpg",
                0,
                "29/04/2020",
                44,
                productCategory1.getId());

        Product product2 = new Product(
                2,
                "Classic Skyline",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                44.95,
                "White",
                "kw-10000006_r.01.jpg",
                21,
                "29/04/2020",
                30,
                productCategory1.getId());

        Product product3 = new Product(
                3,
                "Classic Skyline",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                44.95,
                "White",
                "kw-10000007_r.01.jpg",
                10,
                "29/04/2020",
                39,
                productCategory1.getId());

        Product product4 = new Product(
                4,
                "Classic Skyline",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                44.95,
                "Grey",
                "kw-10000095_r.01.jpg",
                20,
                "29/04/2020",
                39,
                productCategory1.getId());

        Product product5 = new Product(
                5,
                "Classic Skyline",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                44.95,
                "Brown",
                "kw-10000483_r.01.jpg",
                6,
                "29/04/2020",
                21,
                productCategory1.getId());

        Product product6 = new Product(
                6,
                "Classic Skyline",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                44.95,
                "Blue",
                "kw-10000488_r.01.jpg",
                5,
                "29/04/2020",
                30,
                productCategory1.getId());

        Product product7 = new Product(
                7,
                "Special Brass",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                36.27,
                "Black",
                "kw-10000528_r.01.jpg",
                12,
                "29/04/2020",
                37,
                productCategory1.getId());

        Product product8 = new Product(
                8,
                "Perkeo",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                67.00,
                "Blue",
                "kw-10001310.01.jpg",
                14,
                "29/04/2020",
                22,
                productCategory1.getId());

        Product product9 = new Product(
                9,
                "Perkeo",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                67.00,
                "Yellow",
                "kw-10001312.01.jpg",
                19,
                "29/04/2020",
                18,
                productCategory1.getId());

        Product product10 = new Product(
                10,
                "Classic Skyline",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. "
                + "The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. "
                + "These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. "
                + "Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                44.95,
                "Blue",
                "kw-10001738_r.01.jpg",
                21,
                "29/04/2020",
                40,
                productCategory1.getId());

        Product product11 = new Product(
                11,
                "Studio",
                "Milligram",
                "Made from plastic and aluminium, it is a classic ballpoint pen with a piston ink-filling system. "
                + "Its sturdy steel tip is smooth to write with. "
                + "Milligram have created an eye-catching pen that is simultaneously appreciative of the past and relevant in the present.",
                22.53,
                "Brown",
                "mg-2020_bp_pen_bur.01.jpg",
                22,
                "8/05/2020",
                11,
                productCategory3.getId()
        );

        Product product12 = new Product(
                12,
                "Studio",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products.\n"
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design.\n"
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking\n"
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                99.50,
                "White",
                "lm-065_m_r_01_1.jpg",
                16,
                "29/04/2020",
                22,
                productCategory1.getId());

        Product product13 = new Product(
                13,
                "Studio",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products.\n"
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design.\n"
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking\n"
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                99.50,
                "Blue",
                "lm-066_aq_m_r_02_1.jpg",
                19,
                "29/04/2020",
                44,
                productCategory1.getId());

        Product product14 = new Product(
                14,
                "Studio",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products.\n"
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design.\n"
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking\n"
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                99.50,
                "Black",
                "lm-067_bk_b_r_01.jpg",
                6,
                "29/04/2020",
                15,
                productCategory1.getId());

        Product product15 = new Product(
                15,
                "Studio",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products.\n"
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design.\n"
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking\n"
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                99.50,
                "Blue",
                "lm-067_bl_m_r_01_1.jpg",
                7,
                "2/05/2020",
                12,
                productCategory1.getId());

        Product product16 = new Product(
                16,
                "Studio",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products.\n"
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design.\n"
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking\n"
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                99.50,
                "Black",
                "lm-068_pb_ef_r_01.jpg",
                22,
                "2/05/2020",
                34,
                productCategory1.getId());

        Product product17 = new Product(
                17,
                "Scala",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products.\n"
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design.\n"
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking\n"
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                71.68,
                "Grey",
                "lm-078_ef_r_01.jpg",
                5,
                "2/05/2020",
                13,
                productCategory1.getId());

        Product product18 = new Product(
                18,
                "Scala",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products.\n"
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design.\n"
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking\n"
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                71.68,
                "Purple",
                "lm-079_dv_ef_r_01_1.jpg",
                11,
                "2/05/2020",
                23,
                productCategory1.getId());

        Product product19 = new Product(
                19,
                "Scala",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products.\n"
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design.\n"
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking\n"
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                71.68,
                "Black",
                "lm-080_f_r_01.jpg",
                8,
                "2/05/2020",
                22,
                productCategory1.getId());

        Product product20 = new Product(
                20,
                "Safari",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products.\n"
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design.\n"
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking\n"
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                71.68,
                "Brown",
                "lm-090_ef_01.jpg",
                10,
                "2/05/2020",
                40,
                productCategory1.getId());

        Product product21 = new Product(
                21,
                "Custom 823",
                "Pilot Pen",
                "The Pilot Kakuno fountain pen is specially designed to be the perfect introduction to full-sized writing instruments for beginners. "
                + "With the aim of bringing comfort lies with sleeking design, whether you're a child or adult, there's much to love about this model."
                + "The nib is made of stainless steel with one breather hole and a single slit."
                + "The cap and body are made with 85% recycled plastic and have a hexagonal shape allowing fingers to naturally sit comfortably and in the correct position; and the shape also ensures it won't roll away on the desk, with a groove in the cap to help with removal.",
                235.00,
                "Brown",
                "pp-600261.01.jpg",
                17,
                "2/05/2020",
                35,
                productCategory1.getId());

        Product product22 = new Product(
                22,
                "Custom 823",
                "Pilot Pen",
                "The Pilot Kakuno fountain pen is specially designed to be the perfect introduction to full-sized writing instruments for beginners. "
                + "With the aim of bringing comfort lies with sleeking design, whether you're a child or adult, there's much to love about this model."
                + "The nib is made of stainless steel with one breather hole and a single slit."
                + "The cap and body are made with 85% recycled plastic and have a hexagonal shape allowing fingers to naturally sit comfortably and in the correct position; and the shape also ensures it won't roll away on the desk, with a groove in the cap to help with removal.",
                235.00,
                "Brown",
                "pp-600267.02.jpg",
                15,
                "2/05/2020",
                20,
                productCategory1.getId());

        Product product23 = new Product(
                23,
                "Diamond 580",
                "Twsbi",
                "Made from plastic and aluminium, it is a classic fountain pen with a piston ink-filling system. "
                + "Its sturdy steel nib is smooth to write with. "
                + "TWSBI have created an eye-catching fountain pen that is simultaneously appreciative of the past and relevant in the present.",
                120.10,
                "Black",
                "tw-m7443130.01.jpg",
                5,
                "2/05/2020",
                19,
                productCategory1.getId());

        Product product24 = new Product(
                24,
                "Eco",
                "Twsbi",
                "Made from plastic and aluminium, it is a classic fountain pen with a piston ink-filling system. "
                + "Its sturdy steel nib is smooth to write with. "
                + "TWSBI have created an eye-catching fountain pen that is simultaneously appreciative of the past and relevant in the present.",
                75.65,
                "Black",
                "tw-m7444300.01.jpg",
                23,
                "2/05/2020",
                25,
                productCategory1.getId());

        Product product25 = new Product(
                25,
                "Vac Mini",
                "Twsbi",
                "Made from plastic and aluminium, it is a classic fountain pen with a piston ink-filling system. "
                + "Its sturdy steel nib is smooth to write with. "
                + "TWSBI have created an eye-catching fountain pen that is simultaneously appreciative of the past and relevant in the present.",
                78.42,
                "Black",
                "tw-m7445910.01_1.jpg",
                17,
                "8/05/2020",
                17,
                productCategory1.getId());

        Product product26 = new Product(
                26,
                "VAC 700R",
                "Twsbi",
                "Made from plastic and aluminium, it is a classic fountain pen with a piston ink-filling system. "
                + "Its sturdy steel nib is smooth to write with. "
                + "TWSBI have created an eye-catching fountain pen that is simultaneously appreciative of the past and relevant in the present.",
                78.42,
                "Black",
                "tw-m7445970.01.jpg",
                7,
                "8/05/2020",
                20,
                productCategory1.getId());

        Product product27 = new Product(
                27,
                "Eco",
                "Twsbi",
                "Made from plastic and aluminium, it is a classic fountain pen with a piston ink-filling system. "
                + "Its sturdy steel nib is smooth to write with. "
                + "TWSBI have created an eye-catching fountain pen that is simultaneously appreciative of the past and relevant in the present.",
                75.65,
                "Blue",
                "tw-m7446870.01.jpg",
                11,
                "8/05/2020",
                12,
                productCategory1.getId());

        Product product28 = new Product(
                28,
                "Eco",
                "Twsbi",
                "Made from plastic and aluminium, it is a classic fountain pen with a piston ink-filling system. "
                + "Its sturdy steel nib is smooth to write with. "
                + "TWSBI have created an eye-catching fountain pen that is simultaneously appreciative of the past and relevant in the present.",
                75.65,
                "Green",
                "tw-m7446930.01.jpg",
                14,
                "8/05/2020",
                20,
                productCategory1.getId());

        Product product29 = new Product(
                29,
                "Diamond 580",
                "Twsbi",
                "Made from plastic and aluminium, it is a classic fountain pen with a piston ink-filling system. "
                + "Its sturdy steel nib is smooth to write with. "
                + "TWSBI have created an eye-catching fountain pen that is simultaneously appreciative of the past and relevant in the present.",
                120.10,
                "White",
                "tw-m7447060.01.jpg",
                19,
                "8/05/2020",
                13,
                productCategory1.getId());

        Product product30 = new Product(
                30,
                "Eco",
                "Twsbi",
                "Made from plastic and aluminium, it is a classic fountain pen with a piston ink-filling system. "
                + "Its sturdy steel nib is smooth to write with. "
                + "TWSBI have created an eye-catching fountain pen that is simultaneously appreciative of the past and relevant in the present.",
                75.65,
                "Red",
                "tw-m7447120.01.jpg",
                23,
                "8/05/2020",
                17,
                productCategory1.getId());

        Product product31 = new Product(
                31,
                "Diamond 580",
                "Twsbi",
                "Made from plastic and aluminium, it is a classic fountain pen with a piston ink-filling system. "
                + "Its sturdy steel nib is smooth to write with. "
                + "TWSBI have created an eye-catching fountain pen that is simultaneously appreciative of the past and relevant in the present.",
                120.10,
                "Green",
                "tw-m7447170.01.jpg",
                11,
                "8/05/2020",
                23,
                productCategory1.getId());

        Product product32 = new Product(
                32,
                "Scala",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                71.86,
                "Black",
                "ballpoint_01.jpg",
                44,
                "29/04/2020",
                8,
                productCategory3.getId()
        );

        Product product33 = new Product(
                33,
                "Apollo",
                "Fisher Space Pen",
                "Made from plastic and aluminium, it is a classic ballpoint pen with a piston ink-filling system. "
                + "Its sturdy steel tip is smooth to write with. "
                + "Fisher Space Pen have created an eye-catching pen that is simultaneously appreciative of the past and relevant in the present.",
                25.53,
                "Black",
                "black_01_2_28.jpg",
                30,
                "29/04/2020",
                21,
                productCategory3.getId()
        );

        Product product34 = new Product(
                34,
                "Apollo",
                "Fisher Space Pen",
                "Made from plastic and aluminium, it is a classic ballpoint pen with a piston ink-filling system. "
                + "Its sturdy steel tip is smooth to write with. "
                + "Fisher Space Pen have created an eye-catching pen that is simultaneously appreciative of the past and relevant in the present.",
                25.53,
                "Blue",
                "blue_01_2_4.jpg",
                39,
                "29/04/2020",
                10,
                productCategory3.getId()
        );

        Product product35 = new Product(
                35,
                "Wooden",
                "Delfonics",
                "Made from wooden and aluminium, it is a classic ballpoint pen with a piston ink-filling system. "
                + "Its sturdy steel tip is smooth to write with. "
                + "Delfonics have created an eye-catching pen that is simultaneously appreciative of the past and relevant in the present.",
                12.75,
                "Black",
                "df-bp16_black_01_1.jpg",
                39,
                "29/04/2020",
                20,
                productCategory3.getId()
        );

        Product product36 = new Product(
                36,
                "Wooden",
                "Delfonics",
                "Made from wooden and aluminium, it is a classic ballpoint pen with a piston ink-filling system. "
                + "Its sturdy steel tip is smooth to write with. "
                + "Delfonics have created an eye-catching pen that is simultaneously appreciative of the past and relevant in the present.",
                12.75,
                "Blue",
                "df-bp16_db_01_1.jpg",
                21,
                "29/04/2020",
                6,
                productCategory3.getId()
        );

        Product product37 = new Product(
                37,
                "Elegance",
                "Kaweco",
                "Kaweco is well-known for creating a compact, reliable pen with an excellent vintage-meets-contemporary look. "
                + "The model has a screw cap and a stainless steel, iridium-tipped nib made by the Bock family of Heidelberg, Germany. "
                + "These nibs are famous for their consistency. An iridium tip protects the nib from abrasion by contact with paper. "
                + "Kaweco Sport fountain pens are refilled with standard international ink cartridges, such as those made by J. Herbin or Kaweco.",
                60.00,
                "Black",
                "kw-10000841_r.01.jpg",
                30,
                "29/04/2020",
                5,
                productCategory3.getId()
        );

        Product product38 = new Product(
                38,
                "Safari",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                78.42,
                "Transparent",
                "lamy_safari_transparent_ballpoint_01.jpg",
                37,
                "2/05/2020",
                12,
                productCategory3.getId()
        );

        Product product39 = new Product(
                39,
                "Safari",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                78.42,
                "White",
                "lamy_safari_white_ballpoint_01_1.jpg",
                22,
                "2/05/2020",
                14,
                productCategory3.getId()
        );

        Product product40 = new Product(
                40,
                "2000",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                74.22,
                "Brown",
                "lm-203t_01.jpg",
                40,
                "2/05/2020",
                19,
                productCategory3.getId()
        );

        Product product41 = new Product(
                41,
                "Logo Twin Pen",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                84.33,
                "Blue",
                "lm-204__bl.jpg",
                27,
                "2/05/2020",
                21,
                productCategory3.getId()
        );

        Product product42 = new Product(
                42,
                "Logo Twin Pen",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                84.33,
                "Silver",
                "lm-205_bk_r.01.jpg",
                24,
                "2/05/2020",
                20,
                productCategory3.getId()
        );

        Product product43 = new Product(
                43,
                "Logo Twin Pen",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                84.33,
                "Silver",
                "lm-206_r.01.jpg",
                22,
                "2/05/2020",
                15,
                productCategory3.getId()
        );

        Product product44 = new Product(
                44,
                "Econ",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                49.95,
                "Silver",
                "lm-240_ss.jpg",
                44,
                "8/05/2020",
                16,
                productCategory3.getId()
        );

        Product product45 = new Product(
                45,
                "Lx",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                79.95,
                "White",
                "lm-258_thumb.jpg",
                15,
                "8/05/2020",
                19,
                productCategory3.getId()
        );

        Product product46 = new Product(
                46,
                "Studio",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                67.00,
                "Blue",
                "lm-267_bl_01.jpg",
                12,
                "8/05/2020",
                6,
                productCategory3.getId()
        );

        Product product47 = new Product(
                47,
                "2000",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                74.22,
                "Black",
                "lm-401_01.jpg",
                34,
                "8/05/2020",
                7,
                productCategory3.getId()
        );

        Product product48 = new Product(
                48,
                "CP1",
                "Lamy",
                "The Lamy is one of the most well-known worldwide pen marker for their master craftsmanship and functional designs found in their products. "
                + "With the sturdy construction and sleek styling, the pen will appeal to lovers of good design. "
                + "Made from ABS plastic and fitted with a flexible chrome clip, the pen is virtually impossible to break. "
                + "The ergonomic molded grip means it sits comfortably and easily in the hand - it was designed for long hours of note taking. "
                + "Suits Lamy T10 Giant Ink Cartridge and Lamy Z24 Ink Converter.",
                65.00,
                "Silver",
                "lm-759_thumb.jpg",
                14,
                "8/05/2020",
                22,
                productCategory3.getId()
        );

        Product product49 = new Product(
                49,
                "Studio",
                "Milligram",
                "Made from plastic and aluminium, it is a classic ballpoint pen with a piston ink-filling system. "
                + "Its sturdy steel tip is smooth to write with. "
                + "Milligram have created an eye-catching pen that is simultaneously appreciative of the past and relevant in the present.",
                22.53,
                "Purple",
                "mg-2020_bp_pen_bl.01.jpg",
                23,
                "8/05/2020",
                5,
                productCategory3.getId()
        );

        // prepare list
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);
        productList.add(product11);
        productList.add(product12);
        productList.add(product13);
        productList.add(product14);
        productList.add(product15);
        productList.add(product16);
        productList.add(product17);
        productList.add(product18);
        productList.add(product19);
        productList.add(product20);
        productList.add(product21);
        productList.add(product22);
        productList.add(product23);
        productList.add(product24);
        productList.add(product25);
        productList.add(product26);
        productList.add(product27);
        productList.add(product28);
        productList.add(product29);
        productList.add(product30);
        productList.add(product31);
        productList.add(product32);
        productList.add(product33);
        productList.add(product34);
        productList.add(product35);
        productList.add(product36);
        productList.add(product37);
        productList.add(product38);
        productList.add(product39);
        productList.add(product40);
        productList.add(product41);
        productList.add(product42);
        productList.add(product43);
        productList.add(product44);
        productList.add(product45);
        productList.add(product46);
        productList.add(product47);
        productList.add(product48);
        productList.add(product49);

        // add data to db
        db.addRecordsToProductCategoryTable(productCategoryList);
        db.addRecordsToProductTable(productList);
        db.addRecordsToInventoryTable(productList);

        Group group1 = new Group(1, "WWS-GUEST");
        Group group2 = new Group(2, "WWS-USER");
        Group group3 = new Group(3, "WWS-EMPLOYEE");
        Group group4 = new Group(4, "WWS-ADMIN");

        ArrayList<Group> groupList = new ArrayList<>();
        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);
        groupList.add(group4);

        db.addRecordsToGroupTable(groupList);

    }

}
