/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;
import org.jacorb.idl.AddExpr;
import org.jacorb.idl.AndExpr;
import org.jacorb.idl.AnyType;
import org.jacorb.idl.ArrayDeclarator;
import org.jacorb.idl.AttrDecl;
import org.jacorb.idl.AttrRaisesExpr;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.BooleanType;
import org.jacorb.idl.Case;
import org.jacorb.idl.CharType;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.ConstExpr;
import org.jacorb.idl.ConstType;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.Declarator;
import org.jacorb.idl.Definition;
import org.jacorb.idl.Definitions;
import org.jacorb.idl.DoubleType;
import org.jacorb.idl.ElementSpec;
import org.jacorb.idl.EnumType;
import org.jacorb.idl.FixedArraySize;
import org.jacorb.idl.FixedPointConstType;
import org.jacorb.idl.FixedPointType;
import org.jacorb.idl.FloatPtType;
import org.jacorb.idl.FloatType;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.InitDecl;
import org.jacorb.idl.InitParamDecl;
import org.jacorb.idl.IntType;
import org.jacorb.idl.Interface;
import org.jacorb.idl.InterfaceBody;
import org.jacorb.idl.Literal;
import org.jacorb.idl.LongLongType;
import org.jacorb.idl.LongType;
import org.jacorb.idl.Member;
import org.jacorb.idl.MemberList;
import org.jacorb.idl.Module;
import org.jacorb.idl.MultExpr;
import org.jacorb.idl.NativeType;
import org.jacorb.idl.OctetType;
import org.jacorb.idl.OpDecl;
import org.jacorb.idl.OrExpr;
import org.jacorb.idl.ParamDecl;
import org.jacorb.idl.ParseException;
import org.jacorb.idl.PosIntConst;
import org.jacorb.idl.PrimaryExpr;
import org.jacorb.idl.RaisesExpr;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SequenceType;
import org.jacorb.idl.ShiftExpr;
import org.jacorb.idl.ShortType;
import org.jacorb.idl.SimpleDeclarator;
import org.jacorb.idl.SimpleTypeSpec;
import org.jacorb.idl.Spec;
import org.jacorb.idl.StateMember;
import org.jacorb.idl.StringType;
import org.jacorb.idl.StructType;
import org.jacorb.idl.SwitchBody;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.TemplateTypeSpec;
import org.jacorb.idl.Truncatable;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeDeclarator;
import org.jacorb.idl.TypeDef;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.UnaryExpr;
import org.jacorb.idl.UnionType;
import org.jacorb.idl.Value;
import org.jacorb.idl.ValueAbsDecl;
import org.jacorb.idl.ValueBase;
import org.jacorb.idl.ValueBody;
import org.jacorb.idl.ValueBoxDecl;
import org.jacorb.idl.ValueDecl;
import org.jacorb.idl.ValueInheritanceSpec;
import org.jacorb.idl.VoidTypeSpec;
import org.jacorb.idl.XorExpr;
import org.jacorb.idl.fixed_token;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;
import org.jacorb.idl.runtime.char_token;
import org.jacorb.idl.runtime.float_token;
import org.jacorb.idl.runtime.int_token;
import org.jacorb.idl.runtime.long_token;
import org.jacorb.idl.runtime.lr_parser;
import org.jacorb.idl.runtime.str_token;
import org.jacorb.idl.runtime.symbol;
import org.jacorb.idl.runtime.token;

class CUP$actions {
    CUP$actions() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final symbol CUP$do_action(int n, lr_parser lr_parser2, Stack stack, int n2) throws Exception {
        switch (n) {
            case 238: {
                symbol symbol2 = new symbol(3);
                return symbol2;
            }
            case 237: {
                TypeSpec typeSpec = new TypeSpec(43);
                typeSpec.type_spec = (ScopedName)stack.elementAt(n2 - 0);
                return typeSpec;
            }
            case 236: {
                TypeSpec typeSpec = new TypeSpec(43);
                typeSpec.type_spec = (StringType)stack.elementAt(n2 - 0);
                return typeSpec;
            }
            case 235: {
                TypeSpec typeSpec = new TypeSpec(43);
                typeSpec.type_spec = (BaseType)stack.elementAt(n2 - 0);
                return typeSpec;
            }
            case 234: {
                symbol symbol3 = new symbol(2);
                return symbol3;
            }
            case 233: {
                symbol symbol4 = new symbol(2);
                return symbol4;
            }
            case 232: {
                symbol symbol5 = new symbol(1);
                return symbol5;
            }
            case 231: {
                symbol symbol6 = new symbol(1);
                return symbol6;
            }
            case 230: {
                RaisesExpr raisesExpr = new RaisesExpr(83);
                raisesExpr.nameList = (Vector)((SymbolList)stack.elementAt((int)(n2 - 1))).v.clone();
                return raisesExpr;
            }
            case 229: {
                RaisesExpr raisesExpr = new RaisesExpr(82);
                return raisesExpr;
            }
            case 228: {
                RaisesExpr raisesExpr = new RaisesExpr(82);
                raisesExpr.nameList = (Vector)((SymbolList)stack.elementAt((int)(n2 - 1))).v.clone();
                return raisesExpr;
            }
            case 227: {
                int_token int_token2 = new int_token(5);
                int_token2.int_val = 3;
                return int_token2;
            }
            case 226: {
                int_token int_token3 = new int_token(5);
                int_token3.int_val = 2;
                return int_token3;
            }
            case 225: {
                int_token int_token4 = new int_token(5);
                int_token4.int_val = 1;
                return int_token4;
            }
            case 224: {
                ParamDecl paramDecl = new ParamDecl(81);
                paramDecl.paramAttribute = ((int_token)stack.elementAt((int)(n2 - 2))).int_val;
                paramDecl.paramTypeSpec = (TypeSpec)stack.elementAt(n2 - 1);
                paramDecl.simple_declarator = (SimpleDeclarator)stack.elementAt(n2 - 0);
                return paramDecl;
            }
            case 223: {
                SymbolList symbolList = new SymbolList(89);
                symbolList.v.insertElementAt((ParamDecl)stack.elementAt(n2 - 0), 0);
                return symbolList;
            }
            case 222: {
                SymbolList symbolList = new SymbolList(89);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                symbolList.v.insertElementAt((ParamDecl)stack.elementAt(n2 - 2), 0);
                return symbolList;
            }
            case 221: {
                SymbolList symbolList = new SymbolList(91);
                return symbolList;
            }
            case 220: {
                SymbolList symbolList = new SymbolList(91);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 1))).v.clone();
                return symbolList;
            }
            case 219: {
                VoidTypeSpec voidTypeSpec = new VoidTypeSpec(70);
                return voidTypeSpec;
            }
            case 218: {
                TypeSpec typeSpec = new TypeSpec(42);
                typeSpec.type_spec = (VoidTypeSpec)stack.elementAt(n2 - 0);
                return typeSpec;
            }
            case 217: {
                TypeSpec typeSpec = new TypeSpec(42);
                typeSpec.type_spec = (TypeSpec)stack.elementAt(n2 - 0);
                return typeSpec;
            }
            case 216: {
                int_token int_token5 = new int_token(4);
                int_token5.int_val = 0;
                return int_token5;
            }
            case 215: {
                int_token int_token6 = new int_token(4);
                int_token6.int_val = 1;
                return int_token6;
            }
            case 214: {
                OpDecl opDecl = new OpDecl(84);
                opDecl.opAttribute = ((int_token)stack.elementAt((int)(n2 - 5))).int_val;
                opDecl.opTypeSpec = (TypeSpec)stack.elementAt(n2 - 4);
                opDecl.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 3));
                opDecl.paramDecls = (Vector)((SymbolList)stack.elementAt((int)(n2 - 2))).v.clone();
                opDecl.raisesExpr = (RaisesExpr)stack.elementAt(n2 - 1);
                return opDecl;
            }
            case 213: {
                StructType structType = new StructType(51);
                structType.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 3));
                structType.exc = true;
                structType.set_memberlist((MemberList)stack.elementAt(n2 - 1));
                structType.set_included(parser.include_state);
                parser.closeScope(structType);
                return structType;
            }
            case 212: {
                StructType structType = new StructType(51);
                structType.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 2));
                structType.exc = true;
                structType.set_included(parser.include_state);
                parser.closeScope(structType);
                return structType;
            }
            case 211: {
                SymbolList symbolList = new SymbolList(93);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                symbolList.v.insertElementAt((SimpleDeclarator)stack.elementAt(n2 - 2), 0);
                return symbolList;
            }
            case 210: {
                SymbolList symbolList = new SymbolList(93);
                symbolList.v.insertElementAt((SimpleDeclarator)stack.elementAt(n2 - 0), 0);
                return symbolList;
            }
            case 209: {
                AttrRaisesExpr attrRaisesExpr = new AttrRaisesExpr(86);
                attrRaisesExpr.setNameList = (Vector)((SymbolList)stack.elementAt((int)(n2 - 1))).v.clone();
                return attrRaisesExpr;
            }
            case 208: {
                AttrRaisesExpr attrRaisesExpr = new AttrRaisesExpr(86);
                attrRaisesExpr.getNameList = (Vector)((SymbolList)stack.elementAt((int)(n2 - 1))).v.clone();
                return attrRaisesExpr;
            }
            case 207: {
                AttrRaisesExpr attrRaisesExpr = new AttrRaisesExpr(86);
                attrRaisesExpr.getNameList = (Vector)((SymbolList)stack.elementAt((int)(n2 - 1))).v.clone();
                attrRaisesExpr.setNameList = (Vector)((SymbolList)stack.elementAt((int)(n2 - 5))).v.clone();
                return attrRaisesExpr;
            }
            case 206: {
                AttrRaisesExpr attrRaisesExpr = new AttrRaisesExpr(86);
                attrRaisesExpr.getNameList = (Vector)((SymbolList)stack.elementAt((int)(n2 - 5))).v.clone();
                attrRaisesExpr.setNameList = (Vector)((SymbolList)stack.elementAt((int)(n2 - 1))).v.clone();
                return attrRaisesExpr;
            }
            case 205: {
                AttrDecl attrDecl = new AttrDecl(85);
                attrDecl.readOnly = false;
                attrDecl.param_type_spec = (TypeSpec)stack.elementAt(n2 - 2);
                attrDecl.declarators = new SymbolList((SimpleDeclarator)stack.elementAt(n2 - 1));
                attrDecl.getRaisesExpr = new RaisesExpr(((AttrRaisesExpr)stack.elementAt((int)(n2 - 0))).getNameList);
                attrDecl.setRaisesExpr = new RaisesExpr(((AttrRaisesExpr)stack.elementAt((int)(n2 - 0))).setNameList);
                return attrDecl;
            }
            case 204: {
                AttrDecl attrDecl = new AttrDecl(85);
                attrDecl.readOnly = false;
                attrDecl.param_type_spec = (TypeSpec)stack.elementAt(n2 - 1);
                attrDecl.declarators = (SymbolList)stack.elementAt(n2 - 0);
                attrDecl.getRaisesExpr = new RaisesExpr();
                attrDecl.setRaisesExpr = new RaisesExpr();
                return attrDecl;
            }
            case 203: {
                AttrDecl attrDecl = new AttrDecl(85);
                attrDecl.readOnly = true;
                attrDecl.param_type_spec = (TypeSpec)stack.elementAt(n2 - 2);
                attrDecl.declarators = new SymbolList((SimpleDeclarator)stack.elementAt(n2 - 1));
                attrDecl.getRaisesExpr = (RaisesExpr)stack.elementAt(n2 - 0);
                attrDecl.setRaisesExpr = new RaisesExpr();
                return attrDecl;
            }
            case 202: {
                AttrDecl attrDecl = new AttrDecl(85);
                attrDecl.readOnly = true;
                attrDecl.param_type_spec = (TypeSpec)stack.elementAt(n2 - 1);
                attrDecl.declarators = (SymbolList)stack.elementAt(n2 - 0);
                attrDecl.getRaisesExpr = new RaisesExpr();
                attrDecl.setRaisesExpr = new RaisesExpr();
                return attrDecl;
            }
            case 201: {
                FixedArraySize fixedArraySize = new FixedArraySize(80);
                fixedArraySize.pos_int_const = (PosIntConst)stack.elementAt(n2 - 1);
                return fixedArraySize;
            }
            case 200: {
                SymbolList symbolList = new SymbolList(97);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                symbolList.v.insertElementAt((FixedArraySize)stack.elementAt(n2 - 1), 0);
                return symbolList;
            }
            case 199: {
                SymbolList symbolList = new SymbolList(97);
                symbolList.v.insertElementAt((FixedArraySize)stack.elementAt(n2 - 0), 0);
                return symbolList;
            }
            case 198: {
                ArrayDeclarator arrayDeclarator = new ArrayDeclarator(79);
                arrayDeclarator.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 1));
                arrayDeclarator.fixed_array_size_list = (SymbolList)stack.elementAt(n2 - 0);
                return arrayDeclarator;
            }
            case 197: {
                FixedPointType fixedPointType = new FixedPointType(73);
                fixedPointType.digit_expr = ((PosIntConst)stack.elementAt((int)(n2 - 3))).const_expr;
                fixedPointType.scale_expr = ((PosIntConst)stack.elementAt((int)(n2 - 1))).const_expr;
                return fixedPointType;
            }
            case 196: {
                StringType stringType = new StringType(71);
                stringType.setWide();
                return stringType;
            }
            case 195: {
                StringType stringType = new StringType(71);
                return stringType;
            }
            case 194: {
                StringType stringType = new StringType(71);
                stringType.setSize(((PosIntConst)stack.elementAt((int)(n2 - 1))).const_expr);
                stringType.setWide();
                return stringType;
            }
            case 193: {
                StringType stringType = new StringType(71);
                stringType.setSize(((PosIntConst)stack.elementAt((int)(n2 - 1))).const_expr);
                return stringType;
            }
            case 192: {
                SequenceType sequenceType = new SequenceType(72);
                sequenceType.setTypeSpec((SimpleTypeSpec)stack.elementAt(n2 - 1));
                return sequenceType;
            }
            case 191: {
                SequenceType sequenceType = new SequenceType(72);
                sequenceType.max = ((PosIntConst)stack.elementAt((int)(n2 - 1))).const_expr;
                sequenceType.setTypeSpec((SimpleTypeSpec)stack.elementAt(n2 - 3));
                return sequenceType;
            }
            case 190: {
                NativeType nativeType = new NativeType(53);
                nativeType.declarator = (SimpleDeclarator)stack.elementAt(n2 - 0);
                return nativeType;
            }
            case 189: {
                SymbolList symbolList = new SymbolList(96);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                symbolList.v.insertElementAt(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 2))).str_val, 0);
                symbolList.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 2));
                return symbolList;
            }
            case 188: {
                SymbolList symbolList = new SymbolList(96);
                symbolList.v.insertElementAt(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 0))).str_val, 0);
                symbolList.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                return symbolList;
            }
            case 187: {
                EnumType enumType = new EnumType(49);
                enumType.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 3));
                enumType.enumlist = (SymbolList)stack.elementAt(n2 - 1);
                enumType.set_included(parser.include_state);
                return enumType;
            }
            case 186: {
                ElementSpec elementSpec = new ElementSpec(56);
                elementSpec.typeSpec.type_spec = (TypeSpec)stack.elementAt(n2 - 1);
                elementSpec.declarator = (Declarator)stack.elementAt(n2 - 0);
                return elementSpec;
            }
            case 185: {
                SymbolList symbolList = new SymbolList(88);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                symbolList.v.addElement(null);
                return symbolList;
            }
            case 184: {
                SymbolList symbolList = new SymbolList(88);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                symbolList.v.addElement((ConstExpr)stack.elementAt(n2 - 2));
                return symbolList;
            }
            case 183: {
                SymbolList symbolList = new SymbolList(88);
                symbolList.v.addElement(null);
                return symbolList;
            }
            case 182: {
                SymbolList symbolList = new SymbolList(88);
                symbolList.v.addElement((ConstExpr)stack.elementAt(n2 - 1));
                return symbolList;
            }
            case 181: {
                Case case_ = new Case(55);
                case_.element_spec = (ElementSpec)stack.elementAt(n2 - 1);
                case_.case_label_list = (SymbolList)stack.elementAt(n2 - 2);
                return case_;
            }
            case 180: {
                SwitchBody switchBody = new SwitchBody(54);
                switchBody.caseListVector = (Vector)((SwitchBody)stack.elementAt((int)(n2 - 0))).caseListVector.clone();
                switchBody.caseListVector.insertElementAt((Case)stack.elementAt(n2 - 1), 0);
                return switchBody;
            }
            case 179: {
                SwitchBody switchBody = new SwitchBody(54);
                switchBody.caseListVector.insertElementAt((Case)stack.elementAt(n2 - 0), 0);
                return switchBody;
            }
            case 178: {
                TypeSpec typeSpec = new TypeSpec(44);
                typeSpec.type_spec = (ScopedName)stack.elementAt(n2 - 0);
                return typeSpec;
            }
            case 177: {
                TypeSpec typeSpec = new TypeSpec(44);
                typeSpec.set_constr((EnumType)stack.elementAt(n2 - 0));
                return typeSpec;
            }
            case 176: {
                TypeSpec typeSpec = new TypeSpec(44);
                typeSpec.type_spec = (BooleanType)stack.elementAt(n2 - 0);
                return typeSpec;
            }
            case 175: {
                TypeSpec typeSpec = new TypeSpec(44);
                typeSpec.type_spec = (CharType)stack.elementAt(n2 - 0);
                return typeSpec;
            }
            case 174: {
                TypeSpec typeSpec = new TypeSpec(44);
                typeSpec.type_spec = (IntType)stack.elementAt(n2 - 0);
                return typeSpec;
            }
            case 173: {
                UnionType unionType = new UnionType(52);
                unionType.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                parser.closeScope(unionType);
                return unionType;
            }
            case 172: {
                UnionType unionType = new UnionType(52);
                unionType.setSwitchType((TypeSpec)stack.elementAt(n2 - 4));
                unionType.setSwitchBody((SwitchBody)stack.elementAt(n2 - 1));
                unionType.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 7));
                unionType.set_included(parser.include_state);
                parser.closeScope(unionType);
                return unionType;
            }
            case 171: {
                Member member = new Member(76);
                member.type_spec = (TypeSpec)stack.elementAt(n2 - 2);
                member.declarators = (SymbolList)stack.elementAt(n2 - 1);
                return member;
            }
            case 170: {
                MemberList memberList = new MemberList(87);
                memberList.v = (Vector)((MemberList)stack.elementAt((int)(n2 - 0))).v.clone();
                memberList.v.insertElementAt((Member)stack.elementAt(n2 - 1), 0);
                return memberList;
            }
            case 169: {
                MemberList memberList = new MemberList(87);
                memberList.v.insertElementAt((Member)stack.elementAt(n2 - 0), 0);
                return memberList;
            }
            case 168: {
                StructType structType = new StructType(50);
                structType.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                parser.closeScope(structType);
                return structType;
            }
            case 167: {
                StructType structType = new StructType(50);
                structType.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 3));
                structType.exc = false;
                structType.set_memberlist((MemberList)stack.elementAt(n2 - 1));
                structType.set_included(parser.include_state);
                parser.closeScope(structType);
                return structType;
            }
            case 166: {
                AnyType anyType = new AnyType(69);
                return anyType;
            }
            case 165: {
                OctetType octetType = new OctetType(68);
                return octetType;
            }
            case 164: {
                BooleanType booleanType = new BooleanType(67);
                return booleanType;
            }
            case 163: {
                CharType charType = new CharType(66);
                charType.setWide();
                return charType;
            }
            case 162: {
                CharType charType = new CharType(66);
                return charType;
            }
            case 161: {
                LongLongType longLongType = new LongLongType(65);
                return longLongType;
            }
            case 160: {
                LongType longType = new LongType(64);
                return longType;
            }
            case 159: {
                ShortType shortType = new ShortType(63);
                return shortType;
            }
            case 158: {
                IntType intType = new IntType(58);
                intType.type_spec = (ShortType)stack.elementAt(n2 - 0);
                intType.setUnsigned();
                return intType;
            }
            case 157: {
                IntType intType = new IntType(58);
                intType.type_spec = (ShortType)stack.elementAt(n2 - 0);
                return intType;
            }
            case 156: {
                IntType intType = new IntType(58);
                intType.type_spec = (LongLongType)stack.elementAt(n2 - 0);
                intType.setUnsigned();
                return intType;
            }
            case 155: {
                IntType intType = new IntType(58);
                intType.type_spec = (LongType)stack.elementAt(n2 - 0);
                intType.setUnsigned();
                return intType;
            }
            case 154: {
                IntType intType = new IntType(58);
                intType.type_spec = (LongLongType)stack.elementAt(n2 - 0);
                return intType;
            }
            case 153: {
                IntType intType = new IntType(58);
                intType.type_spec = (LongType)stack.elementAt(n2 - 0);
                return intType;
            }
            case 152: {
                DoubleType doubleType = new DoubleType(62);
                doubleType.setLongDouble();
                lexer.emit_warn("IDL type long double not supported by standard IDL/Java mappings!");
                return doubleType;
            }
            case 151: {
                DoubleType doubleType = new DoubleType(62);
                return doubleType;
            }
            case 150: {
                FixedPointConstType fixedPointConstType = new FixedPointConstType(61);
                return fixedPointConstType;
            }
            case 149: {
                FloatType floatType = new FloatType(60);
                return floatType;
            }
            case 148: {
                FloatPtType floatPtType = new FloatPtType(59);
                floatPtType.type_spec = (DoubleType)stack.elementAt(n2 - 0);
                return floatPtType;
            }
            case 147: {
                FloatPtType floatPtType = new FloatPtType(59);
                floatPtType.type_spec = (FloatType)stack.elementAt(n2 - 0);
                return floatPtType;
            }
            case 146: {
                SimpleDeclarator simpleDeclarator = new SimpleDeclarator(78);
                simpleDeclarator.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                return simpleDeclarator;
            }
            case 145: {
                Declarator declarator = new Declarator(77);
                declarator.d = (ArrayDeclarator)stack.elementAt(n2 - 0);
                return declarator;
            }
            case 144: {
                Declarator declarator = new Declarator(77);
                declarator.d = (SimpleDeclarator)stack.elementAt(n2 - 0);
                return declarator;
            }
            case 143: {
                SymbolList symbolList = new SymbolList(94);
                symbolList.v.insertElementAt((Declarator)stack.elementAt(n2 - 0), 0);
                return symbolList;
            }
            case 142: {
                SymbolList symbolList = new SymbolList(94);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                symbolList.v.insertElementAt((Declarator)stack.elementAt(n2 - 2), 0);
                return symbolList;
            }
            case 141: {
                ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(48);
                constrTypeSpec.c_type_spec = (EnumType)stack.elementAt(n2 - 0);
                constrTypeSpec.set_token(((EnumType)stack.elementAt(n2 - 0)).get_token());
                return constrTypeSpec;
            }
            case 140: {
                ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(48);
                constrTypeSpec.c_type_spec = (UnionType)stack.elementAt(n2 - 0);
                constrTypeSpec.set_token(((UnionType)stack.elementAt(n2 - 0)).get_token());
                return constrTypeSpec;
            }
            case 139: {
                ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(48);
                constrTypeSpec.c_type_spec = (StructType)stack.elementAt(n2 - 0);
                constrTypeSpec.set_token(((StructType)stack.elementAt(n2 - 0)).get_token());
                return constrTypeSpec;
            }
            case 138: {
                TemplateTypeSpec templateTypeSpec = new TemplateTypeSpec(47);
                templateTypeSpec.type_spec = (FixedPointType)stack.elementAt(n2 - 0);
                templateTypeSpec.set_token(((FixedPointType)stack.elementAt(n2 - 0)).get_token());
                return templateTypeSpec;
            }
            case 137: {
                TemplateTypeSpec templateTypeSpec = new TemplateTypeSpec(47);
                templateTypeSpec.type_spec = (StringType)stack.elementAt(n2 - 0);
                templateTypeSpec.set_token(((StringType)stack.elementAt(n2 - 0)).get_token());
                return templateTypeSpec;
            }
            case 136: {
                TemplateTypeSpec templateTypeSpec = new TemplateTypeSpec(47);
                templateTypeSpec.type_spec = (SequenceType)stack.elementAt(n2 - 0);
                templateTypeSpec.set_token(((SequenceType)stack.elementAt(n2 - 0)).get_token());
                return templateTypeSpec;
            }
            case 135: {
                BaseType baseType = new BaseType(57);
                baseType.type_spec = new ValueBase(48);
                return baseType;
            }
            case 134: {
                BaseType baseType = new BaseType(57);
                baseType.type_spec = (AnyType)stack.elementAt(n2 - 0);
                return baseType;
            }
            case 133: {
                BaseType baseType = new BaseType(57);
                baseType.type_spec = (OctetType)stack.elementAt(n2 - 0);
                return baseType;
            }
            case 132: {
                BaseType baseType = new BaseType(57);
                baseType.type_spec = (BooleanType)stack.elementAt(n2 - 0);
                return baseType;
            }
            case 131: {
                BaseType baseType = new BaseType(57);
                baseType.type_spec = (CharType)stack.elementAt(n2 - 0);
                return baseType;
            }
            case 130: {
                BaseType baseType = new BaseType(57);
                baseType.type_spec = (IntType)stack.elementAt(n2 - 0);
                return baseType;
            }
            case 129: {
                BaseType baseType = new BaseType(57);
                baseType.type_spec = (FloatPtType)stack.elementAt(n2 - 0);
                return baseType;
            }
            case 128: {
                SimpleTypeSpec simpleTypeSpec = new SimpleTypeSpec(46);
                simpleTypeSpec.type_spec = (ScopedName)stack.elementAt(n2 - 0);
                simpleTypeSpec.set_token(((ScopedName)stack.elementAt(n2 - 0)).get_token());
                return simpleTypeSpec;
            }
            case 127: {
                SimpleTypeSpec simpleTypeSpec = new SimpleTypeSpec(46);
                simpleTypeSpec.type_spec = (TemplateTypeSpec)stack.elementAt(n2 - 0);
                simpleTypeSpec.set_token(((TemplateTypeSpec)stack.elementAt(n2 - 0)).get_token());
                return simpleTypeSpec;
            }
            case 126: {
                SimpleTypeSpec simpleTypeSpec = new SimpleTypeSpec(46);
                simpleTypeSpec.type_spec = (BaseType)stack.elementAt(n2 - 0);
                return simpleTypeSpec;
            }
            case 125: {
                TypeSpec typeSpec = new TypeSpec(41);
                typeSpec.type_spec = (ConstrTypeSpec)stack.elementAt(n2 - 0);
                typeSpec.set_token(((ConstrTypeSpec)stack.elementAt(n2 - 0)).get_token());
                return typeSpec;
            }
            case 124: {
                TypeSpec typeSpec = new TypeSpec(41);
                typeSpec.type_spec = (SimpleTypeSpec)stack.elementAt(n2 - 0);
                typeSpec.set_token(((SimpleTypeSpec)stack.elementAt(n2 - 0)).get_token());
                return typeSpec;
            }
            case 123: {
                TypeDeclarator typeDeclarator = new TypeDeclarator(40);
                typeDeclarator.type_spec = (TypeSpec)stack.elementAt(n2 - 1);
                typeDeclarator.declarators = (SymbolList)stack.elementAt(n2 - 0);
                return typeDeclarator;
            }
            case 122: {
                TypeDef typeDef = new TypeDef(45);
                typeDef.type_declarator = (TypeDeclarator)stack.elementAt(n2 - 0);
                typeDef.set_included(parser.include_state);
                return typeDef;
            }
            case 121: {
                TypeDeclaration typeDeclaration = new TypeDeclaration(39);
                typeDeclaration.type_decl = (NativeType)stack.elementAt(n2 - 0);
                return typeDeclaration;
            }
            case 120: {
                TypeDeclaration typeDeclaration = new TypeDeclaration(39);
                typeDeclaration.type_decl = (EnumType)stack.elementAt(n2 - 0);
                return typeDeclaration;
            }
            case 119: {
                TypeDeclaration typeDeclaration = new TypeDeclaration(39);
                typeDeclaration.type_decl = (UnionType)stack.elementAt(n2 - 0);
                return typeDeclaration;
            }
            case 118: {
                TypeDeclaration typeDeclaration = new TypeDeclaration(39);
                typeDeclaration.type_decl = (StructType)stack.elementAt(n2 - 0);
                return typeDeclaration;
            }
            case 117: {
                TypeDeclaration typeDeclaration = new TypeDeclaration(39);
                typeDeclaration.type_decl = (TypeDef)stack.elementAt(n2 - 0);
                return typeDeclaration;
            }
            case 116: {
                PosIntConst posIntConst = new PosIntConst(30);
                posIntConst.setExpression((ConstExpr)stack.elementAt(n2 - 0));
                return posIntConst;
            }
            case 115: {
                Literal literal = new Literal(75);
                literal.string = "\"\"";
                literal.wide = true;
                return literal;
            }
            case 114: {
                Literal literal = new Literal(75);
                literal.string = "\"" + ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 1))).str_val + "\"";
                literal.wide = true;
                return literal;
            }
            case 113: {
                Literal literal = new Literal(75);
                literal.string = "\"\"";
                return literal;
            }
            case 112: {
                Literal literal = new Literal(75);
                literal.string = "\"" + ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 1))).str_val + "\"";
                return literal;
            }
            case 111: {
                Literal literal = new Literal(74);
                literal.string = "false";
                return literal;
            }
            case 110: {
                Literal literal = new Literal(74);
                literal.string = "true";
                return literal;
            }
            case 109: {
                Literal literal = new Literal(74);
                literal.string = "" + ((float_token)stack.elementAt((int)(n2 - 0))).float_val;
                literal.token = (float_token)stack.elementAt(n2 - 0);
                return literal;
            }
            case 108: {
                Literal literal = new Literal(74);
                literal.string = "" + ((fixed_token)stack.elementAt((int)(n2 - 0))).fixed_val;
                literal.token = (fixed_token)stack.elementAt(n2 - 0);
                return literal;
            }
            case 107: {
                Literal literal = new Literal(74);
                literal.string = ((Literal)stack.elementAt((int)(n2 - 0))).string;
                literal.wide = ((Literal)stack.elementAt((int)(n2 - 0))).wide;
                return literal;
            }
            case 106: {
                Literal literal = new Literal(74);
                literal.string = "'" + ((char_token)stack.elementAt((int)(n2 - 1))).char_val + "'";
                literal.token = (char_token)stack.elementAt(n2 - 1);
                return literal;
            }
            case 105: {
                Literal literal = new Literal(74);
                literal.string = "" + ((long_token)stack.elementAt((int)(n2 - 0))).long_val;
                literal.token = (long_token)stack.elementAt(n2 - 0);
                return literal;
            }
            case 104: {
                Literal literal = new Literal(74);
                literal.string = "-" + ((long_token)stack.elementAt((int)(n2 - 0))).long_val;
                literal.token = (long_token)stack.elementAt(n2 - 0);
                return literal;
            }
            case 103: {
                Literal literal = new Literal(74);
                literal.string = "-" + ((int_token)stack.elementAt((int)(n2 - 0))).int_val;
                literal.token = (int_token)stack.elementAt(n2 - 0);
                return literal;
            }
            case 102: {
                Literal literal = new Literal(74);
                literal.string = "" + ((int_token)stack.elementAt((int)(n2 - 0))).int_val;
                literal.token = (int_token)stack.elementAt(n2 - 0);
                return literal;
            }
            case 101: {
                PrimaryExpr primaryExpr = new PrimaryExpr(38);
                primaryExpr.symbol = (ConstExpr)stack.elementAt(n2 - 1);
                return primaryExpr;
            }
            case 100: {
                PrimaryExpr primaryExpr = new PrimaryExpr(38);
                primaryExpr.symbol = (Literal)stack.elementAt(n2 - 0);
                return primaryExpr;
            }
            case 99: {
                PrimaryExpr primaryExpr = new PrimaryExpr(38);
                primaryExpr.symbol = (ScopedName)stack.elementAt(n2 - 0);
                return primaryExpr;
            }
            case 98: {
                str_token str_token2 = new str_token(6);
                str_token2.str_val = "~";
                return str_token2;
            }
            case 97: {
                str_token str_token3 = new str_token(6);
                str_token3.str_val = "+";
                return str_token3;
            }
            case 96: {
                str_token str_token4 = new str_token(6);
                str_token4.str_val = "-";
                return str_token4;
            }
            case 95: {
                UnaryExpr unaryExpr = new UnaryExpr(37);
                unaryExpr.primary_expr = (PrimaryExpr)stack.elementAt(n2 - 0);
                return unaryExpr;
            }
            case 94: {
                UnaryExpr unaryExpr = new UnaryExpr(37);
                unaryExpr.primary_expr = (PrimaryExpr)stack.elementAt(n2 - 0);
                unaryExpr.unary_op = ((str_token)stack.elementAt((int)(n2 - 1))).str_val;
                return unaryExpr;
            }
            case 93: {
                MultExpr multExpr = new MultExpr(36);
                multExpr.unary_expr = (UnaryExpr)stack.elementAt(n2 - 0);
                multExpr.mult_expr = (MultExpr)stack.elementAt(n2 - 2);
                multExpr.operator = "%";
                return multExpr;
            }
            case 92: {
                MultExpr multExpr = new MultExpr(36);
                multExpr.unary_expr = (UnaryExpr)stack.elementAt(n2 - 0);
                multExpr.mult_expr = (MultExpr)stack.elementAt(n2 - 2);
                multExpr.operator = "/";
                return multExpr;
            }
            case 91: {
                MultExpr multExpr = new MultExpr(36);
                multExpr.unary_expr = (UnaryExpr)stack.elementAt(n2 - 0);
                multExpr.mult_expr = (MultExpr)stack.elementAt(n2 - 2);
                multExpr.operator = "*";
                return multExpr;
            }
            case 90: {
                MultExpr multExpr = new MultExpr(36);
                multExpr.unary_expr = (UnaryExpr)stack.elementAt(n2 - 0);
                return multExpr;
            }
            case 89: {
                AddExpr addExpr = new AddExpr(35);
                addExpr.add_expr = (AddExpr)stack.elementAt(n2 - 2);
                addExpr.mult_expr = (MultExpr)stack.elementAt(n2 - 0);
                addExpr.operator = "-";
                return addExpr;
            }
            case 88: {
                AddExpr addExpr = new AddExpr(35);
                addExpr.add_expr = (AddExpr)stack.elementAt(n2 - 2);
                addExpr.mult_expr = (MultExpr)stack.elementAt(n2 - 0);
                addExpr.operator = "+";
                return addExpr;
            }
            case 87: {
                AddExpr addExpr = new AddExpr(35);
                addExpr.mult_expr = (MultExpr)stack.elementAt(n2 - 0);
                return addExpr;
            }
            case 86: {
                ShiftExpr shiftExpr = new ShiftExpr(34);
                shiftExpr.add_expr = (AddExpr)stack.elementAt(n2 - 0);
                shiftExpr.shift_expr = (ShiftExpr)stack.elementAt(n2 - 2);
                shiftExpr.operator = ">>";
                return shiftExpr;
            }
            case 85: {
                ShiftExpr shiftExpr = new ShiftExpr(34);
                shiftExpr.add_expr = (AddExpr)stack.elementAt(n2 - 0);
                shiftExpr.shift_expr = (ShiftExpr)stack.elementAt(n2 - 2);
                shiftExpr.operator = "<<";
                return shiftExpr;
            }
            case 84: {
                ShiftExpr shiftExpr = new ShiftExpr(34);
                shiftExpr.add_expr = (AddExpr)stack.elementAt(n2 - 0);
                return shiftExpr;
            }
            case 83: {
                AndExpr andExpr = new AndExpr(33);
                andExpr.and_expr = (AndExpr)stack.elementAt(n2 - 2);
                andExpr.shift_expr = (ShiftExpr)stack.elementAt(n2 - 0);
                return andExpr;
            }
            case 82: {
                AndExpr andExpr = new AndExpr(33);
                andExpr.shift_expr = (ShiftExpr)stack.elementAt(n2 - 0);
                return andExpr;
            }
            case 81: {
                XorExpr xorExpr = new XorExpr(32);
                xorExpr.and_expr = (AndExpr)stack.elementAt(n2 - 0);
                xorExpr.xor_expr = (XorExpr)stack.elementAt(n2 - 2);
                return xorExpr;
            }
            case 80: {
                XorExpr xorExpr = new XorExpr(32);
                xorExpr.and_expr = (AndExpr)stack.elementAt(n2 - 0);
                return xorExpr;
            }
            case 79: {
                OrExpr orExpr = new OrExpr(31);
                orExpr.or_expr = (OrExpr)stack.elementAt(n2 - 2);
                orExpr.xor_expr = (XorExpr)stack.elementAt(n2 - 0);
                return orExpr;
            }
            case 78: {
                OrExpr orExpr = new OrExpr(31);
                orExpr.xor_expr = (XorExpr)stack.elementAt(n2 - 0);
                return orExpr;
            }
            case 77: {
                ConstExpr constExpr = new ConstExpr(29);
                constExpr.or_expr = (OrExpr)stack.elementAt(n2 - 0);
                return constExpr;
            }
            case 76: {
                ConstType constType = new ConstType(28);
                constType.symbol = (ScopedName)stack.elementAt(n2 - 0);
                constType.set_token(((ScopedName)stack.elementAt(n2 - 0)).get_token());
                return constType;
            }
            case 75: {
                ConstType constType = new ConstType(28);
                constType.symbol = (OctetType)stack.elementAt(n2 - 0);
                return constType;
            }
            case 74: {
                ConstType constType = new ConstType(28);
                constType.symbol = (StringType)stack.elementAt(n2 - 0);
                return constType;
            }
            case 73: {
                ConstType constType = new ConstType(28);
                constType.symbol = (FixedPointConstType)stack.elementAt(n2 - 0);
                return constType;
            }
            case 72: {
                ConstType constType = new ConstType(28);
                constType.symbol = (FloatPtType)stack.elementAt(n2 - 0);
                return constType;
            }
            case 71: {
                ConstType constType = new ConstType(28);
                constType.symbol = (BooleanType)stack.elementAt(n2 - 0);
                return constType;
            }
            case 70: {
                ConstType constType = new ConstType(28);
                constType.symbol = (CharType)stack.elementAt(n2 - 0);
                return constType;
            }
            case 69: {
                ConstType constType = new ConstType(28);
                constType.symbol = (IntType)stack.elementAt(n2 - 0);
                return constType;
            }
            case 68: {
                ConstDecl constDecl = new ConstDecl(27);
                constDecl.set_name(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 2))).str_val);
                constDecl.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 2));
                constDecl.const_expr = (ConstExpr)stack.elementAt(n2 - 0);
                constDecl.const_type = (ConstType)stack.elementAt(n2 - 3);
                constDecl.set_included(parser.include_state);
                return constDecl;
            }
            case 67: {
                InitParamDecl initParamDecl = new InitParamDecl(26);
                initParamDecl.paramTypeSpec = (TypeSpec)stack.elementAt(n2 - 1);
                initParamDecl.simple_declarator = (SimpleDeclarator)stack.elementAt(n2 - 0);
                return initParamDecl;
            }
            case 66: {
                SymbolList symbolList = new SymbolList(90);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                symbolList.v.insertElementAt((InitParamDecl)stack.elementAt(n2 - 2), 0);
                return symbolList;
            }
            case 65: {
                SymbolList symbolList = new SymbolList(90);
                symbolList.v.insertElementAt((InitParamDecl)stack.elementAt(n2 - 0), 0);
                return symbolList;
            }
            case 64: {
                InitDecl initDecl = new InitDecl(25);
                initDecl.name = ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 4))).str_val;
                initDecl.raisesExpr = (RaisesExpr)stack.elementAt(n2 - 1);
                return initDecl;
            }
            case 63: {
                InitDecl initDecl = new InitDecl(25);
                initDecl.name = ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 5))).str_val;
                initDecl.paramDecls = (Vector)((SymbolList)stack.elementAt((int)(n2 - 3))).v.clone();
                initDecl.raisesExpr = (RaisesExpr)stack.elementAt(n2 - 1);
                return initDecl;
            }
            case 62: {
                StateMember stateMember = new StateMember(24);
                stateMember.isPublic = false;
                stateMember.type_spec = (TypeSpec)stack.elementAt(n2 - 2);
                stateMember.declarators = (SymbolList)stack.elementAt(n2 - 1);
                return stateMember;
            }
            case 61: {
                StateMember stateMember = new StateMember(24);
                stateMember.isPublic = true;
                stateMember.type_spec = (TypeSpec)stack.elementAt(n2 - 2);
                stateMember.declarators = (SymbolList)stack.elementAt(n2 - 1);
                return stateMember;
            }
            case 60: {
                Definition definition = new Definition(23);
                definition.set_declaration((InitDecl)stack.elementAt(n2 - 0));
                return definition;
            }
            case 59: {
                Definition definition = new Definition(23);
                definition.set_declaration((StateMember)stack.elementAt(n2 - 0));
                return definition;
            }
            case 58: {
                Definition definition = new Definition(23);
                definition.set_declaration(((Definition)stack.elementAt(n2 - 0)).get_declaration());
                return definition;
            }
            case 57: {
                Definitions definitions = new Definitions(22);
                return definitions;
            }
            case 56: {
                Definitions definitions = new Definitions(22);
                definitions.v = (Vector)((Definitions)stack.elementAt((int)(n2 - 0))).v.clone();
                definitions.v.insertElementAt((Definition)stack.elementAt(n2 - 1), 0);
                return definitions;
            }
            case 55: {
                Truncatable truncatable = new Truncatable(15);
                return truncatable;
            }
            case 54: {
                ValueInheritanceSpec valueInheritanceSpec = new ValueInheritanceSpec(21);
                return valueInheritanceSpec;
            }
            case 53: {
                ValueInheritanceSpec valueInheritanceSpec = new ValueInheritanceSpec(21);
                lexer.emit_warn("Illegal IDL: empty inheritance spec after colon!");
                return valueInheritanceSpec;
            }
            case 52: {
                ValueInheritanceSpec valueInheritanceSpec = new ValueInheritanceSpec(21);
                valueInheritanceSpec.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 2))).v.clone();
                valueInheritanceSpec.supports = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                return valueInheritanceSpec;
            }
            case 51: {
                ValueInheritanceSpec valueInheritanceSpec = new ValueInheritanceSpec(21);
                valueInheritanceSpec.truncatable = (Truncatable)stack.elementAt(n2 - 3);
                valueInheritanceSpec.truncatable.scopedName = (ScopedName)((SymbolList)stack.elementAt((int)(n2 - 2))).v.remove(0);
                valueInheritanceSpec.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 2))).v.clone();
                valueInheritanceSpec.supports = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                return valueInheritanceSpec;
            }
            case 50: {
                ValueInheritanceSpec valueInheritanceSpec = new ValueInheritanceSpec(21);
                valueInheritanceSpec.supports = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                return valueInheritanceSpec;
            }
            case 49: {
                ValueInheritanceSpec valueInheritanceSpec = new ValueInheritanceSpec(21);
                valueInheritanceSpec.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                return valueInheritanceSpec;
            }
            case 48: {
                ValueInheritanceSpec valueInheritanceSpec = new ValueInheritanceSpec(21);
                valueInheritanceSpec.truncatable = (Truncatable)stack.elementAt(n2 - 1);
                valueInheritanceSpec.truncatable.scopedName = (ScopedName)((SymbolList)stack.elementAt((int)(n2 - 0))).v.remove(0);
                valueInheritanceSpec.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                return valueInheritanceSpec;
            }
            case 47: {
                ValueDecl valueDecl = new ValueDecl(18);
                valueDecl.name = ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 4))).str_val;
                valueDecl.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 4));
                valueDecl.setInheritanceSpec((ValueInheritanceSpec)stack.elementAt(n2 - 3));
                valueDecl.setValueElements((Definitions)stack.elementAt(n2 - 1));
                valueDecl.isCustomMarshalled(false);
                return valueDecl;
            }
            case 46: {
                ValueDecl valueDecl = new ValueDecl(18);
                valueDecl.name = ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 0))).str_val;
                valueDecl.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                valueDecl.isCustomMarshalled(false);
                return valueDecl;
            }
            case 45: {
                ValueDecl valueDecl = new ValueDecl(18);
                valueDecl.name = ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 4))).str_val;
                valueDecl.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 4));
                valueDecl.setInheritanceSpec((ValueInheritanceSpec)stack.elementAt(n2 - 3));
                valueDecl.setValueElements((Definitions)stack.elementAt(n2 - 1));
                valueDecl.isCustomMarshalled(true);
                return valueDecl;
            }
            case 44: {
                ValueBody valueBody = new ValueBody(20);
                valueBody.commit();
                return valueBody;
            }
            case 43: {
                ValueBody valueBody = new ValueBody(20);
                valueBody.v = (Vector)((ValueBody)stack.elementAt((int)(n2 - 0))).v.clone();
                valueBody.v.insertElementAt((Definition)stack.elementAt(n2 - 1), 0);
                return valueBody;
            }
            case 42: {
                ValueAbsDecl valueAbsDecl = new ValueAbsDecl(19);
                valueAbsDecl.name = ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 0))).str_val;
                valueAbsDecl.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                return valueAbsDecl;
            }
            case 41: {
                ValueAbsDecl valueAbsDecl = new ValueAbsDecl(19);
                valueAbsDecl.name = ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 4))).str_val;
                valueAbsDecl.setInheritanceSpec((ValueInheritanceSpec)stack.elementAt(n2 - 3));
                valueAbsDecl.body = (ValueBody)stack.elementAt(n2 - 1);
                ((ValueBody)stack.elementAt(n2 - 1)).set_name(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 4))).str_val);
                ((ValueBody)stack.elementAt((int)(n2 - 1))).myAbsValue = valueAbsDecl;
                ((ValueBody)stack.elementAt(n2 - 1)).setEnclosingSymbol(valueAbsDecl);
                valueAbsDecl.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 4));
                return valueAbsDecl;
            }
            case 40: {
                ValueBoxDecl valueBoxDecl = new ValueBoxDecl(17);
                valueBoxDecl.name = ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 1))).str_val;
                valueBoxDecl.typeSpec = (TypeSpec)stack.elementAt(n2 - 0);
                valueBoxDecl.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 1));
                return valueBoxDecl;
            }
            case 39: {
                Value value = new Value(16);
                value.setValue((ValueBoxDecl)stack.elementAt(n2 - 0));
                return value;
            }
            case 38: {
                Value value = new Value(16);
                value.setValue((ValueAbsDecl)stack.elementAt(n2 - 0));
                return value;
            }
            case 37: {
                Value value = new Value(16);
                value.setValue((ValueDecl)stack.elementAt(n2 - 0));
                return value;
            }
            case 36: {
                ScopedName scopedName = new ScopedName(14);
                scopedName.typeName = "org.omg.CORBA.Object";
                return scopedName;
            }
            case 35: {
                ScopedName scopedName = new ScopedName(14);
                scopedName.setId(((ScopedName)stack.elementAt((int)(n2 - 2))).typeName + "." + ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 0))).str_val);
                scopedName.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                return scopedName;
            }
            case 34: {
                ScopedName scopedName = new ScopedName(14);
                scopedName.setId("." + ((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 0))).str_val);
                scopedName.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                return scopedName;
            }
            case 33: {
                ScopedName scopedName = new ScopedName(14);
                scopedName.setId(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 0))).str_val);
                scopedName.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                return scopedName;
            }
            case 32: {
                SymbolList symbolList = new SymbolList(92);
                symbolList.v.insertElementAt((ScopedName)stack.elementAt(n2 - 0), 0);
                return symbolList;
            }
            case 31: {
                SymbolList symbolList = new SymbolList(92);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                symbolList.v.insertElementAt((ScopedName)stack.elementAt(n2 - 2), 0);
                return symbolList;
            }
            case 30: {
                SymbolList symbolList = new SymbolList(95);
                return symbolList;
            }
            case 29: {
                SymbolList symbolList = new SymbolList(95);
                lexer.emit_warn("Illegal IDL: empty inheritance spec after colon!");
                return symbolList;
            }
            case 28: {
                SymbolList symbolList = new SymbolList(95);
                symbolList.v = (Vector)((SymbolList)stack.elementAt((int)(n2 - 0))).v.clone();
                return symbolList;
            }
            case 27: {
                Definition definition = new Definition(13);
                definition.set_declaration((OpDecl)stack.elementAt(n2 - 1));
                return definition;
            }
            case 26: {
                Definition definition = new Definition(13);
                definition.set_declaration((AttrDecl)stack.elementAt(n2 - 1));
                return definition;
            }
            case 25: {
                Definition definition = new Definition(13);
                definition.set_declaration((StructType)stack.elementAt(n2 - 1));
                return definition;
            }
            case 24: {
                Definition definition = new Definition(13);
                definition.set_declaration((ConstDecl)stack.elementAt(n2 - 1));
                return definition;
            }
            case 23: {
                Definition definition = new Definition(13);
                definition.set_declaration((TypeDeclaration)stack.elementAt(n2 - 1));
                return definition;
            }
            case 22: {
                InterfaceBody interfaceBody = new InterfaceBody(12);
                interfaceBody.commit();
                return interfaceBody;
            }
            case 21: {
                InterfaceBody interfaceBody = new InterfaceBody(12);
                interfaceBody.v = (Vector)((InterfaceBody)stack.elementAt((int)(n2 - 0))).v.clone();
                interfaceBody.v.insertElementAt((Definition)stack.elementAt(n2 - 1), 0);
                return interfaceBody;
            }
            case 20: {
                Interface interface_ = new Interface(11);
                interface_.set_pseudo();
                interface_.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                parser.closeScope(interface_);
                return interface_;
            }
            case 19: {
                Interface interface_ = new Interface(11);
                interface_.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                interface_.set_abstract();
                interface_.set_locality(true);
                parser.closeScope(interface_);
                return interface_;
            }
            case 18: {
                Interface interface_ = new Interface(11);
                interface_.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                interface_.set_abstract();
                parser.closeScope(interface_);
                return interface_;
            }
            case 17: {
                Interface interface_ = new Interface(11);
                interface_.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 0));
                parser.closeScope(interface_);
                return interface_;
            }
            case 16: {
                Interface interface_ = new Interface(11);
                interface_.set_pseudo();
                interface_.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 4));
                interface_.inheritanceSpec = (SymbolList)stack.elementAt(n2 - 3);
                interface_.body = (InterfaceBody)stack.elementAt(n2 - 1);
                ((InterfaceBody)stack.elementAt(n2 - 1)).set_pseudo();
                ((InterfaceBody)stack.elementAt(n2 - 1)).set_name(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 4))).str_val);
                ((InterfaceBody)stack.elementAt((int)(n2 - 1))).my_interface = interface_;
                ((InterfaceBody)stack.elementAt(n2 - 1)).setEnclosingSymbol(interface_);
                interface_.set_included(parser.include_state);
                parser.closeScope(interface_);
                return interface_;
            }
            case 15: {
                Interface interface_ = new Interface(11);
                interface_.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 4));
                interface_.inheritanceSpec = (SymbolList)stack.elementAt(n2 - 3);
                interface_.body = (InterfaceBody)stack.elementAt(n2 - 1);
                ((InterfaceBody)stack.elementAt(n2 - 1)).set_name(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 4))).str_val);
                ((InterfaceBody)stack.elementAt((int)(n2 - 1))).my_interface = interface_;
                ((InterfaceBody)stack.elementAt(n2 - 1)).setEnclosingSymbol(interface_);
                interface_.set_included(parser.include_state);
                interface_.set_locality(true);
                parser.closeScope(interface_);
                return interface_;
            }
            case 14: {
                Interface interface_ = new Interface(11);
                interface_.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 4));
                interface_.set_abstract();
                interface_.inheritanceSpec = (SymbolList)stack.elementAt(n2 - 3);
                interface_.body = (InterfaceBody)stack.elementAt(n2 - 1);
                ((InterfaceBody)stack.elementAt(n2 - 1)).set_name(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 4))).str_val);
                ((InterfaceBody)stack.elementAt((int)(n2 - 1))).my_interface = interface_;
                ((InterfaceBody)stack.elementAt(n2 - 1)).setEnclosingSymbol(interface_);
                interface_.set_included(parser.include_state);
                parser.closeScope(interface_);
                return interface_;
            }
            case 13: {
                Interface interface_ = new Interface(11);
                interface_.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 4));
                interface_.inheritanceSpec = (SymbolList)stack.elementAt(n2 - 3);
                interface_.body = (InterfaceBody)stack.elementAt(n2 - 1);
                ((InterfaceBody)stack.elementAt(n2 - 1)).set_name(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 4))).str_val);
                ((InterfaceBody)stack.elementAt((int)(n2 - 1))).my_interface = interface_;
                ((InterfaceBody)stack.elementAt(n2 - 1)).setEnclosingSymbol(interface_);
                interface_.set_included(parser.include_state);
                parser.closeScope(interface_);
                return interface_;
            }
            case 12: {
                Module module = new Module(10);
                module.spec = (Definitions)stack.elementAt(n2 - 1);
                module.set_token((org.jacorb.idl.str_token)stack.elementAt(n2 - 3));
                module.setPackage(((org.jacorb.idl.str_token)stack.elementAt((int)(n2 - 3))).str_val);
                module.set_included(parser.include_state);
                ((Definitions)stack.elementAt(n2 - 1)).setEnclosingSymbol(module);
                parser.closeScope(module);
                return module;
            }
            case 11: {
                Definition definition = new Definition(8);
                definition.set_declaration((Value)stack.elementAt(n2 - 1));
                return definition;
            }
            case 10: {
                Definition definition = new Definition(8);
                definition.set_declaration((Module)stack.elementAt(n2 - 1));
                return definition;
            }
            case 9: {
                Definition definition = new Definition(8);
                definition.set_declaration((Interface)stack.elementAt(n2 - 1));
                return definition;
            }
            case 8: {
                Definition definition = new Definition(8);
                definition.set_declaration((StructType)stack.elementAt(n2 - 1));
                return definition;
            }
            case 7: {
                Definition definition = new Definition(8);
                definition.set_declaration((ConstDecl)stack.elementAt(n2 - 1));
                return definition;
            }
            case 6: {
                Definition definition = new Definition(8);
                definition.set_declaration((TypeDeclaration)stack.elementAt(n2 - 1));
                return definition;
            }
            case 5: {
                Definitions definitions = new Definitions(9);
                definitions.v.insertElementAt((Definition)stack.elementAt(n2 - 0), 0);
                return definitions;
            }
            case 4: {
                Definitions definitions = new Definitions(9);
                definitions.v = (Vector)((Definitions)stack.elementAt((int)(n2 - 0))).v.clone();
                definitions.v.insertElementAt((Definition)stack.elementAt(n2 - 1), 0);
                return definitions;
            }
            case 3: {
                Spec spec = new Spec(7);
                return spec;
            }
            case 2: {
                Spec spec = new Spec(7);
                spec.definitions = (Vector)((Definitions)stack.elementAt((int)(n2 - 0))).v.clone();
                parser cfr_ignored_0 = (parser)lr_parser2;
                if (parser.package_prefix != null) {
                    parser cfr_ignored_1 = (parser)lr_parser2;
                    spec.setPackage(parser.package_prefix);
                }
                spec.parse();
                if (lexer.error_count != 0) {
                    lexer.emit_error(lexer.error_count + " error(s).");
                    throw new ParseException("Lexer errors");
                }
                if (parser.pending_interfaces.size() > 0) {
                    long l = System.currentTimeMillis() + 20000L;
                    Hashtable hashtable = parser.pending_interfaces;
                    synchronized (hashtable) {
                        while (parser.activeParseThreads() > 0 && parser.pending_interfaces.size() > 0 && System.currentTimeMillis() < l) {
                            parser.pending_interfaces.wait(60000L);
                        }
                    }
                }
                if (parser.pending_interfaces.size() > 0 && !parser.sloppy) {
                    parser.fatal_error("Undefined interface: " + (String)parser.pending_interfaces.keys().nextElement(), null);
                }
                parser.done_parsing = true;
                parser cfr_ignored_2 = (parser)lr_parser2;
                if (!parser.parse_only) {
                    parser cfr_ignored_3 = (parser)lr_parser2;
                    IDLTreeVisitor iDLTreeVisitor = parser.getGenerator();
                    if (iDLTreeVisitor != null) {
                        parser cfr_ignored_4 = (parser)lr_parser2;
                        if (parser.addbackend) {
                            spec.print(new PrintWriter(System.out));
                        }
                        spec.accept(iDLTreeVisitor);
                    } else {
                        spec.print(new PrintWriter(System.out));
                    }
                }
                return spec;
            }
            case 1: {
                token token2 = new token(98);
                return token2;
            }
            case 0: {
                token token3 = new token(0);
                lr_parser2.done_parsing();
                return token3;
            }
        }
        throw new Exception("Invalid action number found in internal parse table");
    }
}

