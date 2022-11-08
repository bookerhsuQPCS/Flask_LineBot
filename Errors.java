package com.momo.middle.util;

public enum Errors {

  /**
   * <pre>
   * 
   * 需求單號: 2017060800045051
   * 需求主旨: L I N E P A Y
   * 
   * </pre>
   */

  LPB461("非排程執行主機，不可執行【LINE Pay退款更新】排程。"),

  LPB462("執行【LINE Pay退款更新】排程，發生Exception。"),

  LPB463("呼叫moec執行【LINE Pay退款更新】排程，回傳的rtn是null。"),

  LPB464("呼叫moec執行【LINE Pay退款更新】排程，回傳的rtnCode不是200。"),

  LPB011("「以CARD_NO取得所有訂單付款結帳(TORDERRECEIPTS)資訊」傳入值有誤，傳入的json是null。"),

  LPB012("「以CARD_NO取得所有訂單付款結帳(TORDERRECEIPTS)資訊」傳入值有誤，傳入的json.domain是空值。"),

  LPB013("「以CARD_NO取得所有訂單付款結帳(TORDERRECEIPTS)資訊」傳入值有誤，傳入的json.cardNo是空值。"),

  LPB014("「以CARD_NO取得所有訂單付款結帳(TORDERRECEIPTS)資訊」，取得的List是null或空值。"),

  LPB015("「以CARD_NO取得所有訂單付款結帳(TORDERRECEIPTS)資訊」，發生Exception。"),

  LPB016("執行單筆【LINE Pay入款更新】傳入值有誤，傳入的json.transactionId長度不等於19。"),

  LPB201("【LINE Pay退款更新】傳入值有誤，傳入的json是null。"),

  LPB202("【LINE Pay退款更新】傳入值有誤，傳入的json.domain是空值。"),

  LPB203("【LINE Pay退款更新】傳入值有誤，傳入的json.receiptNo是空值。"),

  LPB204("【LINE Pay退款更新】傳入值有誤，傳入的json.refundTransactionId是空值。"),

  LPB205("【LINE Pay退款更新】發生錯誤，以入款編號(RECEIPT_NO)取得訂單付款結帳(TORDERRECEIPTS)資訊，回傳的map是null。"),

  LPB206("【LINE Pay退款更新】發生錯誤，此筆TORDERRECEIPTS的doFlag不是10。"),

  LPB207("【LINE Pay退款更新】發生錯誤，此筆TORDERRECEIPTS不是使用LinePay退款。"),

  LPB208("【LINE Pay退款更新】發生錯誤，以入款編號(RECEIPT_NO)取得訂單付款結帳(TORDERRECEIPTS)資訊，回傳的QUEST_AMT小於等於0。"),

  LPB209("【LINE Pay退款更新】發生錯誤，此筆TORDERRECEIPTS的cancelYn不是0。"),

  LPB210("【LINE Pay退款更新】發生錯誤，TORDERRECEIPTS更新成功的筆數不等於1筆。"),

  LPB211("【LINE Pay退款更新】發生錯誤，無法取得訂單付款階段(TORDERRECEIPTSPROC)的入款序號(RECEIPT_SEQ)。"),

  LPB212("【LINE Pay退款更新】發生錯誤，TORDERRECEIPTS新增成功的筆數不等於1筆。"),

  LPB213("【LINE Pay退款更新】傳入值有誤，傳入的json.refundTransactionDate是空值。"),

  LPB214("【LINE Pay退款更新】傳入值有誤，傳入的json.refundTransactionDate日期格式(yyyy-MM-dd HH:mm:ss)有誤。"),

  LPB307("執行單筆【LINE Pay退款更新】，發生Exception。"),

  LPB316("執行單筆【LINE Pay入款更新】，發生Exception。"),

  LPB331("非排程執行主機，不可執行【LINE Pay入款更新】排程。"),

  LPB332("呼叫moec執行【LINE Pay入款更新】排程，發生Exception。"),

  LPB333("呼叫moec執行【LINE Pay入款更新】排程，回傳的rtn是null。"),

  LPB334("呼叫moec執行【LINE Pay入款更新】排程，回傳的rtnCode不是200。"),

  LPB571("取得insertDate介於指定日期區間內可能漏執行【LINE Pay入款更新】的訂單，傳入值有誤，傳入的json是null。"),

  LPB572("取得insertDate介於指定日期區間內可能漏執行【LINE Pay入款更新】的訂單，傳入值有誤，傳入的domain是空值。"),

  LPB573("取得insertDate介於指定日期區間內可能漏執行【LINE Pay入款更新】的訂單，傳入值有誤，傳入的startDate日期格式(yyyyMMddHHmmss)有誤。"),

  LPB574("取得insertDate介於指定日期區間內可能漏執行【LINE Pay入款更新】的訂單，傳入值有誤，傳入的endDate日期格式(yyyyMMddHHmmss)有誤。"),

  LPB575("取得insertDate介於指定日期區間內可能漏執行【LINE Pay入款更新】的訂單，發生Exception。"),

  LPB576("取得insertDate介於指定日期區間內可能漏執行【LINE Pay入款更新】的訂單，取得的List是null。"),

  LPB601("取得insertDate介於指定日期區間內待執行【LINE Pay退款更新】的訂單，傳入值有誤，傳入的json是null。"),

  LPB602("取得insertDate介於指定日期區間內待執行【LINE Pay退款更新】的訂單，傳入值有誤，傳入的domain是空值。"),

  LPB603("取得insertDate介於指定日期區間內待執行【LINE Pay退款更新】的訂單，傳入值有誤，傳入的startDate日期格式(yyyyMMddHHmmss)有誤。"),

  LPB604("取得insertDate介於指定日期區間內待執行【LINE Pay退款更新】的訂單，傳入值有誤，傳入的endDate日期格式(yyyyMMddHHmmss)有誤。"),

  LPB605("取得insertDate介於指定日期區間內待執行【LINE Pay退款更新】的訂單，發生Exception。"),

  LPB606("取得insertDate介於指定日期區間內待執行【LINE Pay退款更新】的訂單，取得的List是null。"),

  LPB001("執行單筆【LINE Pay入款更新】傳入值有誤，傳入的json是null。"),

  LPB002("執行單筆【LINE Pay入款更新】傳入值有誤，傳入的json.domain是空值。"),

  LPB003("執行單筆【LINE Pay入款更新】傳入值有誤，傳入的json.receiptNo是空值。"),

  LPB004("執行單筆【LINE Pay入款更新】發生錯誤，以入款編號(RECEIPT_NO)取得訂單付款結帳(TORDERRECEIPTS)資訊，回傳的map是null。"),

  LPB005("執行單筆【LINE Pay入款更新】發生錯誤，此筆TORDERRECEIPTS的doFlag不是10。"),

  LPB006("執行單筆【LINE Pay入款更新】發生錯誤，此筆TORDERRECEIPTS不是使用LINE Pay付款。"),

  LPB007("執行單筆【LINE Pay入款更新】發生錯誤，此筆TORDERRECEIPTS的cancelYn不是0。"),

  LPB008("執行單筆【LINE Pay入款更新】傳入值有誤，傳入的json.questAmt非數值。"),

  LPB009("執行單筆【LINE Pay入款更新】發生錯誤，以入款編號(RECEIPT_NO)取得訂單付款結帳(TORDERRECEIPTS)資訊，回傳的QUEST_AMT小於等於0。"),

  LPB010("執行單筆【LINE Pay入款更新】發生錯誤，傳入的json.questAmt與此筆TORDERRECEIPTS的questAmt不符。"),

  LPB017("執行單筆【LINE Pay入款更新】發生錯誤，TORDERRECEIPTS更新成功的筆數不等於1筆。"),

  LPB019("執行單筆【LINE Pay入款更新】發生錯誤，新增訂單付款階段(TORDERRECEIPTSPROC)新增成功的筆數不等於1筆。"),

  LPB020("執行單筆【LINE Pay入款更新】發生錯誤，無法取得訂購階段資料檔(TORDERPROC)的訂單進行序號(ORDER_P_SEQ)。"),

  LPB021("執行單筆【LINE Pay入款更新】發生錯誤，取得的訂購階段資料檔(TORDERPROC)的訂單進行序號(ORDER_P_SEQ)，回傳map是null。"),

  LPB018("執行單筆【LINE Pay入款更新】發生錯誤，無法取得訂單付款階段(TORDERRECEIPTSPROC)的入款序號(RECEIPT_SEQ)。"),

  LPB022("執行單筆【LINE Pay入款更新】發生錯誤，新增訂購階段資料檔(TORDERPROC)新增成功的筆數不等於1筆。"),

  LPB023("執行單筆【LINE Pay入款更新】發生錯誤，無法取得訂單細節(TORDERDT)的現有數量(SYSLAST)。"),

  LPB024("執行單筆【LINE Pay入款更新】發生錯誤，取得的訂單細節(TORDERDT)的現有數量(SYSLAST)，回傳的map是null。"),

  LPB025("執行單筆【LINE Pay入款更新】發生錯誤，取得的訂單細節(TORDERDT)的現有數量(SYSLAST)，回傳的SYSLAST小於等於0"),

  LPB026("執行單筆【LINE Pay入款更新】發生錯誤，取得的訂單細節(TORDERDT)的SYSLAST有誤。"),

  LPB027("執行單筆【LINE Pay入款更新】發生錯誤，syslasts是空值。"),

  LPB028("執行單筆【LINE Pay入款更新】發生錯誤，goods[0]或goods[1]有誤。"),

  LPB029("執行單筆【LINE Pay入款更新】發生錯誤，更新訂購庫存(TORDERSTOCK)更新成功的筆數不等於1筆。"),

  LPB030("執行單筆【LINE Pay入款更新】發生錯誤，count4和mapSYSLAST的筆數不符。"),

  LPB081("【LINE Pay入款更新】發生錯誤，custMap是空值。"),

  LPB082("【LINE Pay入款更新】發生錯誤，無法取得配送地(TRECEIVER)。"),

  LPB083("【LINE Pay入款更新】發生錯誤，RECEIVER_SEQ有誤。"),

  LPB084("【LINE Pay入款更新】發生錯誤，map2是空值。"),

  LPB085("【LINE Pay入款更新】發生錯誤，goodsList是空值。"),

  LPB086("【LINE Pay入款更新】發生錯誤，呼叫Tmax的ORDER_STOCK_I服務重新計算預定送貨日，回傳是null。"),

  LPB087("【LINE Pay入款更新】發生錯誤，呼叫Tmax的ORDER_STOCK_I服務重新計算預定送貨日，回傳值有誤。"),

  LPB088("【LINE Pay入款更新】發生錯誤，list3和list2的筆數不符。"),

  LPB089("【LINE Pay入款更新】發生錯誤，沒有DELY_HOPE_DATE或DELY_HOPE_YN或DELY_HOPE_TIME。"),

  LPB090("【LINE Pay入款更新】發生錯誤，更新訂單細節(TORDERDT)的進行階段(DO_FLAG)更新成功的筆數不大於1筆。"),

  LPB091("【LINE Pay入款更新】發生錯誤，呼叫Tmax的ORDER_STOCK_I服務重新計算預定送貨日，回傳值是null。"),

  LPB092("執行單筆【LINE Pay入款更新】發生錯誤，取得的訂購階段資料檔(TORDERPROC)的訂單進行序號(ORDER_P_SEQ)，回傳值是null。"),

  LPB093(
      "執行單筆【LINE Pay入款更新】發生錯誤，取得的訂單細節(TORDERDT)的現有數量(SYSLAST)，回傳的ORDER_NO或ORDER_G_SEQ或ORDER_D_SEQ或ORDER_W_SEQ或GOODS_CODE或GOODSDT_CODE或DELY_HOPE_DATE是空值。"),

  LPB099("【LINE Pay入款更新】發生錯誤，更新訂單細節(TORDERDT)的預計到貨日(DELY_HOPE_DATE)更新成功的筆數不等於1筆。"),

  /**
   * JKO Pay
   */
  JKOB001("執行【入款更新】傳入參數為空"),
  JKOB002("執行【入款更新】傳入訂單編號錯誤"),
  JKOB003("執行【入款更新】傳入交易序號錯誤"),
  JKOB004("執行【檢查TORDERRECEIPTS】傳入參數為空"),
  JKOB005("執行【檢查TORDERRECEIPTS】ltTOrderReceipts為空"),
  JKOB006("執行【檢查TORDERRECEIPTS】ltTOrderReceipts size不等於1"),
  JKOB007("執行【檢查TORDERRECEIPTS】mTOrderReceipts為空"),
  JKOB008("執行【檢查TORDERRECEIPTS】receipt_no錯誤"),
  JKOB009("執行【檢查TORDERRECEIPTS】order_no錯誤"),
  JKOB010("執行【檢查TORDERRECEIPTS】cust_no錯誤"),
  JKOB011("執行【檢查TORDERRECEIPTS】do_flag不等於10"),
  JKOB012("執行【檢查TORDERRECEIPTS】settle_gb不等於15"),
  JKOB013("執行【檢查TORDERRECEIPTS】card_bank_code不等於N03"),
  JKOB014("執行【檢查TORDERRECEIPTS】quest_amt錯誤"),
  JKOB015("執行【檢查TORDERRECEIPTS】cancel_yn不等於0"),
  JKOB016("執行【入款更新】jObjTOrderReceipts為空"),
  JKOB017("執行【入款更新】更新TORDERRECEIPTS args有資料空值"),
  JKOB018("執行【入款更新】更新TORDERRECEIPTS失敗"),
  JKOB019("執行【新增TORDERRECEIPTSPROC】傳入參數為空"),
  JKOB020("執行【新增TORDERRECEIPTSPROC】receipt_no為空"),
  JKOB021("執行【新增TORDERRECEIPTSPROC】receipt_seq為空"),
  JKOB022("執行【新增TORDERRECEIPTSPROC】新增TORDERRECEIPTSPROC args2有資料空值"),
  JKOB023("執行【新增TORDERRECEIPTSPROC】新增TORDERRECEIPTSPROC失敗"),
  JKOB024("執行【新增TORDERPROC】傳入參數為空"),
  JKOB025("執行【新增TORDERPROC】order_no為空"),
  JKOB026("執行【新增TORDERPROC】do_flag為空"),
  JKOB027("執行【新增TORDERPROC】proc_date為空"),
  JKOB028("執行【新增TORDERPROC】proc_id為空"),
  JKOB029("執行【新增TORDERPROC】ltOrderProc為空"),
  JKOB030("執行【新增TORDERPROC】mOrderProc為空"),
  JKOB031("執行【新增TORDERPROC】新增TORDERPROC args有資料空值"),
  JKOB032("執行【新增TORDERPROC】新增TORDERPROC失敗"),
  JKOB033("執行【入款更新】jObjInsTOrderProcRtn為空"),
  JKOB034("執行【檢查TORDERDT】傳入參數為空"),
  JKOB035("執行【檢查TORDERDT】ltOrdDt為空"),
  JKOB036("執行【檢查TORDERDT】mOrdDt為空"),
  JKOB037("執行【檢查TORDERDT】order_g_seq非數值"),
  JKOB038("執行【檢查TORDERDT】order_d_seq非數值"),
  JKOB039("執行【檢查TORDERDT】order_w_seq非數值"),
  JKOB040("執行【檢查TORDERDT】cust_no非數值"),
  JKOB041("執行【檢查TORDERDT】receiver_seq非數值"),
  JKOB042("執行【檢查TORDERDT】goods_code非數值"),
  JKOB043("執行【檢查TORDERDT】goodsdt_code非數值"),
  JKOB044("執行【檢查TORDERDT】syslast非數值"),
  JKOB045("執行【檢查TORDERDT】dely_hope_date非日期"),
  JKOB046("執行【檢查TORDERDT】取得收件人資訊發生例外錯誤"),
  JKOB047("執行【入款更新】jObjChkTOrderDtRtn為空"),
  JKOB048("執行【入款更新】jArrOrdDt為空"),
  JKOB049("執行【更新TORDERSTOCK】傳入參數為空"),
  JKOB050("執行【更新TORDERSTOCK】jObjSyslast為空"),
  JKOB051("執行【更新TORDERSTOCK】goodsKey錯誤"),
  JKOB052("執行【更新TORDERSTOCK】syslast非數值"),
  JKOB053("執行【更新TORDERSTOCK】更新TORDERSTOCK失敗"),
  JKOB054("執行【更新TORDERSTOCK】更新筆數異常"),
  JKOB055("執行【入款更新】jObjUpdTOrderStockRtn為空"),
  JKOB056("執行【更新訂單明細指定配送日】傳入參數為空"),
  JKOB057("執行【更新訂單明細指定配送日】jObjOrgDelyHopeDates為空"),
  JKOB058("執行【更新訂單明細指定配送日】ltTCounsel為空"),
  JKOB059("執行【更新訂單明細指定配送日】mTCounsel為空"),
  JKOB060("執行【更新訂單明細指定配送日】訂單序號有資料空值"),
  JKOB061("執行【更新訂單明細指定配送日】jObjOrdDt為空"),
  JKOB062("執行【更新訂單明細指定配送日】更新指定配送日有資料空值"),
  JKOB063("執行【更新訂單明細指定配送日】更新TORDERDT失敗"),
  JKOB064("執行【更新訂單明細指定配送日】更新筆數異常"),
  JKOB065("執行【入款更新】jObjUpdTOrderDtDelyHopeDateRtn為空"),
  JKOB066("執行【入款更新】更新訂單明細進行階段失敗"),

  /**
   * ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
   * 
   * <pre>
   * 
   * 需求單號: 2013060400012334
   * 需求主旨: SET商品精進需求
   * 複製商品頁功能(商品圖、特色標語、特色內文、專推、規格書)
   * 
   * </pre>
   */

  SGDS0001("傳入參數有誤"),

  SGDS0002("以SET主商品品號撈TSETGOODS的SET子商品，發生Exception"),

  SGDS0003("以SET主商品品號撈TSETGOODS的SET子商品，撈不到SET子商品，請確認傳入品號是否為SET主商品品號"),

  SGDS0004("SET主商品以GOODS_CODE取得TGOODSIMAGE(商品圖檔)，發生Exception"),

  SGDS0005("SET子商品以GOODS_CODE取得TGOODSIMAGE(商品圖檔)，發生Exception"),

  SGDS0006("取得SET主商品的TDESCRIBE(商品敘述書)，發生Exception"),

  SGDS0007("取得SET子商品的TDESCRIBE(商品敘述書)，發生Exception"),

  SGDS0008("取得SET主商品的專推，發生Exception"),

  SGDS0009("取得SET子商品的專推，發生Exception"),

  SGDS0010("傳入的setGoods有誤"),

  SGDS0011("傳入的setGoods有誤"),

  SGDS0012("以GOODS_CODE刪除TGOODSIMAGE，發生Exception"),

  SGDS0013("新增TGOODSIMAGE，發生Exception"),

  SGDS0014("傳入的setGoods有誤"),

  SGDS0015("傳入的參數有誤"),

  SGDS0016("刪除TDESCRIBE，發生Exception"),

  SGDS0017("刪除TF_DESCRIBE，發生Exception"),

  SGDS0018("新增TDESCRIBE，發生Exception"),

  SGDS0019("傳入的setGoods有誤"),

  SGDS0020("傳入的參數有誤"),

  SGDS0021("刪除TF_GOODS_FILE，發生Exception"),

  SGDS0022("新增TF_GOODS_FILE，發生Exception"),

  SGDS0023("傳入的參數有誤"),

  SGDS0024("以USER_ID取得使用者(TUSER)，發生Exception"),

  SGDS0025("以USER_ID取得使用者(TUSER)，回傳值有誤"),

  SGDS0026("以USER_ID取得使用者(TUSER)，END_DATE有誤"),

  SGDS0027("以USER_ID取得使用者(TUSER)，SYSDATE已超過該使用者的END_DATE"),

  /** 
   * <pre>
   * 
   * 需求單號: 2015073000026619
   * 需求主旨: 新增電子票券機制
   * 
   * </pre>
   */

  BETS0001("傳入的資料有誤。"),

  BETS0002("以ENTP_CODE取得TENTERPRISE，發生Exception。"),

  BETS0003("以ENTP_CODE取得TENTERPRISE，method回傳null。"),

  BPTS0001("以GOODS_CODE取得電子票券商品資訊，傳入的goodsCode是空值。"),

  BPTS0002("以GOODS_CODE取得電子票券商品資訊，發生Exception。"),

  BPTS0003("以GOODS_CODE取得電子票券商品資訊，DAO回傳null。"),

  BPTS0008("以GOODS_CODE取得電子票券商品DT資訊，發生Exception。"),

  BPTS0009("以GOODS_CODE取得電子票券商品DT資訊，DAO回傳null。"),

  BPTS0010("查詢TGOODSDT可接單量相關資料，發生Exception。"),

  BPTS0011("查詢TGOODSDT可接單量相關資料，DAO回傳null。"),

  BPTS0012("查詢TGOODSDT可接單量相關資料，DAO回傳資料有誤，HashMap是null。"),

  BPTS0013("查詢TGOODSDT可接單量相關資料，DAO回傳資料有誤，F_TGOODSDT_GOODSDT_CODE是null。"),

  BPTS0014("查詢TGOODSDT可接單量相關資料，DAO回傳資料有誤，F_LONG1非數值。"),

  BPTS0016("以GOODS_CODE、GOODSDT_CODE取得電子票券商品提報分店設定檔資訊，發生Exception。"),

  BPTS0017("以GOODS_CODE、GOODSDT_CODE取得電子票券商品提報分店設定檔資訊，DAO回傳null。"),

  /**
   * <pre>
   * 
   * 需求單號: 2015082600027265
   * 需求主旨: 商品週期配送功能
   * 
   * </pre>
   */

  // ↓↓週期配送排程立單
  DASH000001("非排程執行主機，不可執行『週期配送排程立單』。"),

  // ↓↓處理expectDate(預計配送日期)

  DASH001001("執行『處理expectDate(預計配送日期)』，傳入值有誤，傳入的request或json是null。"),

  DASH001002("執行『處理expectDate(預計配送日期)』，傳入值有誤，傳入的expectDate日期格式(yyyy/MM/dd)有誤。"),

  // ↓↓取得TF_CYCLEM(週期配送主檔)資訊

  DASH002001("執行『取得TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的json或cycles是null。"),

  DASH002002("執行『取得TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的json.expectDate日期格式有誤(yyyy/MM/dd)。"),

  DASH002003("執行『取得TF_CYCLEM(週期配送主檔)資訊』SQL，發生Exception。"),

  DASH002004("執行『取得TF_CYCLEM(週期配送主檔)資訊』SQL，取得的list是null。"),

  DASH002005("執行『取得TF_CYCLEM(週期配送主檔)資訊』SQL，取得的list.size等於0，取得的週期配送主檔資訊為0筆。"),

  DASH002006("執行『取得TF_CYCLEM(週期配送主檔)資訊』，取得的週期配送主檔資訊為0筆。"),

  // ↓↓取得TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊

  DASH003001("執行『取得TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的cycle是null。"),

  DASH003002("執行『取得TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的cycle.getTfCyclem()是null。"),

  DASH003003("執行『取得TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的cycle.getTfCyclem().getCycleNo()是空值。"),

  DASH003004("執行『取得TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』SQL，發生Exception。"),

  DASH003005("執行『取得TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』SQL，取得的list是null。"),

  DASH003006("執行『取得TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』SQL，取得的list.size等於0，取得的週期配送商品明細檔資訊為0筆。"),

  DASH003007("執行『取得TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的cycle.getTfCyclem().getGoodsCode()是空值。"),

  // ↓↓判斷該檔週期配送的原始訂單的週期配送商品是否有取消

  DASH004001("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle是null。"),

  DASH004002(":執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getExpectDate()日期格式有誤(yyyy/MM/dd)。"),

  DASH004003("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getSeq()非數值。"),

  DASH004004("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getTfCyclem()是null。"),

  DASH004005("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getTfCyclem().getCycleNo()是空值。"),

  DASH004006("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getTfCyclem().getCustNo()是空值。"),

  DASH004007("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getTfCyclem().getOrderNo()是空值。"),

  DASH004008("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()是null。"),

  DASH004009("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入單筆的tfCycleGoodsdt物件是null。"),

  DASH004010("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()單筆的getOrderGSeq()是空值。"),

  DASH004011("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()單筆的getOrderDSeq()是空值。"),

  DASH004012("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有取消』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()單筆的getGoodsCode()是空值。"),

  DASH004013("執行『取得TORDERDT(訂單細節)資訊』SQL，發生Exception。"),
  
  DASH004014("執行『取得TORDERDT(訂單細節)資訊』SQL，取得的TORDERDT的ORDER_QTY不等於TF_CYCLE_GOODSDT的ORDER_QTY。"),

  DASH004015("因為該檔週期配送的原始訂單的週期配送商品有全部/部份取消，所以中止該檔週期配送。"),

  // ↓↓判斷該檔週期配送的原始訂單的週期配送商品是否有建退

  DASH005001("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle是null。"),

  DASH005002("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getExpectDate()日期格式有誤(yyyy/MM/dd)。"),

  DASH005003("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getSeq()非數值。"),

  DASH005004("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getTfCyclem()是null。"),

  DASH005005("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getTfCyclem().getCycleNo()是空值。"),

  DASH005006("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getTfCyclem().getCustNo()是空值。"),

  DASH005007("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getTfCyclem().getOrderNo()是空值。"),

  DASH005008("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()是null。"),

  DASH005009("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入單筆的tfCycleGoodsdt物件是null。"),

  DASH005010("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()單筆的getOrderGSeq()是空值。"),

  DASH005011("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()單筆的getOrderDSeq()是空值。"),

  DASH005012("執行『判斷該檔週期配送的原始訂單的週期配送商品是否有建退』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()單筆的getGoodsCode()是空值。"),

  DASH005013("執行『取得TCLAIMDT(換貨退貨明細)資訊』SQL，發生Exception。"),

  DASH005014("執行『取得TCLAIMDT(換貨退貨明細)資訊』SQL，取得的list是null。"),

  DASH005015("因為該檔週期配送的原始訂單的週期配送商品有建退，所以中止該檔週期配送。"),

  // ↓↓取得TF_CYCLEDT(週期配送明細檔)資訊

  DASH006001("執行『取得TF_CYCLEDT(週期配送明細檔)資訊』，傳入值有誤，傳入的cycle是null。"),

  DASH006002("執行『取得TF_CYCLEDT(週期配送明細檔)資訊』，傳入值有誤，傳入的cycle.getSeq()是空值。"),

  DASH006003("執行『取得TF_CYCLEDT(週期配送明細檔)資訊』，傳入值有誤，傳入的cycle.getTfCyclem()是null。"),

  DASH006004("執行『取得TF_CYCLEDT(週期配送明細檔)資訊』，傳入值有誤，傳入的cycle.getTfCyclem().getCycleNo()是空值。"),

  DASH006005("執行『取得TF_CYCLEDT(週期配送明細檔)資訊』，傳入值有誤，傳入的cycle.getTfCyclem().getOrderNo()是空值。"),

  DASH006006("執行『取得TF_CYCLEDT(週期配送明細檔)資訊』SQL，發生Exception。"),

  DASH006007("執行『取得TF_CYCLEDT(週期配送明細檔)資訊』SQL，取得的list是null。"),

  DASH006008("執行『取得TF_CYCLEDT(週期配送明細檔)資訊』SQL，取得的list.size等於0，取得的週期配送商品明細檔資訊為0筆。"),

  // ↓↓取得購買人資訊

  DASH007001("執行『取得購買人資訊』，傳入值有誤，傳入的order是null。"),

  DASH007002("執行『取得購買人資訊』，傳入值有誤，傳入的order.getCustNo()是空值。"),

  DASH007003("執行『取得購買人資訊』SQL，發生Exception。"),

  DASH007004("執行『取得購買人資訊』SQL，取得的list是null。"),

  DASH007005("執行『取得購買人資訊』SQL，取得的list.size等於0，取得的會員資訊為0筆。"),

  DASH007006("執行『取得購買人資訊』，TMEMBER的WITHDRAWAL_YN是1，此客編已退出會員。"),

  DASH007007("執行『取得購買人資訊』，取得的會員資訊為0筆。"),

  // ↓↓成立訂單

  DASH008001("執行『成立訂單』，傳入值有誤，傳入的order是null。"),

  DASH008002("呼叫Tmax『成立訂單』，發生Exception。"),

  DASH008003("呼叫Tmax『成立訂單』，立單失敗，回傳的map是null。"),

  // ↓↓檢查商品的銷售區分

  DASH009001("執行『檢查商品的銷售區分』，傳入值有誤，傳入的cycle是null。"),

  DASH009002("執行『檢查商品的銷售區分』，傳入值有誤，傳入的cycle.getExpectDate()日期格式有誤(yyyy/MM/dd)。"),

  DASH009003("執行『檢查商品的銷售區分』，傳入值有誤，傳入的cycle.getSeq()非數值。"),

  DASH009004("執行『檢查商品的銷售區分』，傳入值有誤，傳入的cycle.getTfCyclem()是null。"),

  DASH009005("執行『檢查商品的銷售區分』，傳入值有誤，傳入的cycle.getTfCyclem().getCycleNo()是空值。"),

  DASH009006("執行『檢查商品的銷售區分』，傳入值有誤，傳入的cycle.getTfCycledts()是null。"),

  DASH009007("執行『檢查商品的銷售區分』，傳入值有誤，單筆tfCycledt是null。"),

  DASH009008("執行『檢查商品的銷售區分』，傳入值有誤，前一筆tfCycledt是null。"),

  DASH009009("執行『檢查商品的銷售區分』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()是null。"),

  DASH009010("執行『檢查商品的銷售區分』，傳入值有誤，TF_CYCLE_GOODSDT的GOODS_CODE是空值。"),

  DASH009011("執行『取得商品銷售區分』SQL，發生Exception。"),

  DASH009012("執行『取得商品銷售區分』SQL，發生錯誤，取得的map是空的。"),

  DASH009013("執行『取得商品銷售區分』SQL，回傳的map.SALE_GB有誤，TGOODS的SALE_GB不是00(進行)或11(暫時中斷)或19(永久中斷)。"),

  DASH009014("執行『檢查商品的銷售區分』，商品的SALE_GB是11(暫時中斷)。"),

  DASH009015("執行『檢查商品的銷售區分』，商品的SALE_GB是19(永久中斷)。"),

  // ↓↓檢查商品現有庫存量

  DASH010001("執行『檢查商品現有庫存量』，傳入值有誤，傳入的cycle是null。"),

  DASH010002("執行『檢查商品現有庫存量』，傳入值有誤，傳入的cycle.getExpectDate()日期格式有誤(yyyy/MM/dd)。"),

  DASH010003("執行『檢查商品現有庫存量』，傳入值有誤，傳入的cycle.getSeq()非數值。"),

  DASH010004("執行『檢查商品現有庫存量』，傳入值有誤，傳入的cycle.getTfCyclem()是null。"),

  DASH010005("執行『檢查商品現有庫存量』，傳入值有誤，傳入的cycle.getTfCyclem().getCycleNo()是空值。"),

  DASH010006("執行『檢查商品現有庫存量』，傳入值有誤，傳入的cycle.getTfCycledts()是null。"),

  DASH010007("執行『檢查商品現有庫存量』，傳入值有誤，單筆tfCycledt是null。"),

  DASH010008("執行『檢查商品現有庫存量』，傳入值有誤，前一筆tfCycledt是null。"),

  DASH010009("執行『檢查商品現有庫存量』，傳入值有誤，傳入的cycle.getTfCycleGoodsdts()是null。"),

  DASH010010("執行『檢查商品現有庫存量』，傳入值有誤，TF_CYCLE_GOODSDT的GOODS_CODE是空值。"),

  DASH010011("執行『檢查商品現有庫存量』，傳入值有誤，TF_CYCLE_GOODSDT的GOODSDT_CODE是空值。"),

  DASH010012("執行『檢查商品現有庫存量』，傳入值有誤，TF_CYCLE_GOODSDT的ORDER_QTY小於等於≤0。"),

  DASH010013("呼叫Tmax『取得商品款式庫存數』，發生Exception。"),

  DASH010014("執行『檢查商品現有庫存量』，商品現有庫存量低於預計訂購數量，可接單量不足。"),

  // ↓↓更新TF_CYCLEM(週期配送主檔)

  DASH011001("執行『更新TF_CYCLEM(週期配送主檔)』，傳入值有誤，傳入的cycleNo是空值。"),

  DASH011002("執行『更新TF_CYCLEM(週期配送主檔)』，傳入值有誤，傳入的status長度不等於1。"),

  DASH011003("執行『更新TF_CYCLEM(週期配送主檔)』，傳入值有誤，傳入的modifyId是空值。"),

  DASH011004("執行『更新TF_CYCLEM(週期配送主檔)』，傳入值有誤，傳入的modifyDate日期格式有誤(yyyy/MM/dd HH:mm:ss)。"),

  DASH011005("執行『更新TF_CYCLEM(週期配送主檔)』SQL，發生Exception。"),

  DASH011006("執行『更新TF_CYCLEM(週期配送主檔)』SQL，發生錯誤，TF_CYCLEM更新成功的筆數不等於1筆。"),

  // ↓↓更新TF_CYCLEDT(週期配送明細檔)

  DASH012001("執行『更新TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，傳入的cycleNo是空值。"),

  DASH012002("執行『更新TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，傳入的seq是空值。"),

  DASH012003("執行『更新TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，傳入的status長度不等於1。"),

  DASH012004("執行『更新TF_CYCLEDT(週期配送明細檔)』SQL，發生錯誤，TF_CYCLEDT更新成功的筆數不等於1筆。"),

  DASH012005("執行『更新TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，傳入的orderNo長度大於14。"),

  DASH012006("執行『更新TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，傳入的errorCode長度大於10。"),

  DASH012007("執行『更新TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，傳入的apIp長度大於15。"),

  DASH012008("執行『更新TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，傳入的modifyDate日期格式有誤(yyyy/MM/dd HH:mm:ss)。"),

  DASH012009("執行『更新TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，傳入的modifyId長度大於10。"),

  DASH012010("執行『更新TF_CYCLEDT(週期配送明細檔)』SQL，發生Exception。"),

  // ↓↓取得訂單編號

  DASH013001("執行『取得訂單編號』，傳入值有誤，傳入的order是null。"),

  DASH013002("呼叫Tmax『取得訂單編號』，發生Exception。"),

  DASH013003("呼叫Tmax『取得訂單編號』，回傳的訂單編號是空值。"),
  
  // ↓↓特別處理 收件人資料
  
  DASH014001("執行『特別處理 收件人資料』，傳入值有誤，傳入的order是null。"),
  
  DASH014002("執行『特別處理 收件人資料』，傳入值有誤，傳入的custNo或receiverSeq是空值。"),
  
  DASH014003("執行『取得收件郵遞區號』SQL，發生Exception。"),
  
  DASH014004("執行『取得收件郵遞區號』SQL，取得的map是null。"),
  
  DASH014005("執行『取得收件郵遞區號』SQL，回傳的receiverPost或receiverPostSeq"),

  // ↓↓佔量

  DASH015001("執行『佔量』，傳入值有誤，傳入的order是null。"),

  DASH015002("執行『佔量』，傳入值有誤，傳入的order.getOrderdtList()是null。"),

  DASH015003("呼叫Tmax的ORDER_STOCK_I服務進行佔量，Tmax回傳的list是null。"),

  DASH015004("呼叫Tmax的ORDER_STOCK_I服務進行佔量，Tmax回傳的佔量筆數有誤。"),

  DASH015005("呼叫Tmax的ORDER_STOCK_I服務進行佔量，Tmax回傳的map是null"),

  DASH015006("呼叫Tmax的ORDER_STOCK_I服務進行佔量，Tmax回傳的F_SQL(庫存代碥)有誤，F_SQL不是數值。"),

  DASH015007("呼叫Tmax的ORDER_STOCK_I服務進行佔量，Tmax回傳可接單量不足或庫存量不足。"),

  DASH015008("呼叫Tmax的ORDER_STOCK_I服務進行佔量，Tmax回傳的F_LONG2(目前可接單量)有誤，F_LONG2不是數值。"),

  DASH015009("呼叫Tmax的ORDER_STOCK_I服務進行佔量，Tmax回傳的F_LONG2(目前可接單量)小於訂購量。"),

  DASH015010("呼叫Tmax的ORDER_STOCK_I服務進行佔量，Tmax回傳的F_TORDDT_ORDER_QTY(保留量)有誤，F_TORDDT_ORDER_QTY不是數值。"),

  DASH015011("呼叫Tmax的ORDER_STOCK_I服務進行佔量，Tmax回傳的F_TORDDT_ORDER_QTY(保留量)小於訂購量。"),

  // ↓↓打包DashOrderdt物件
  
  DASH016001("執行『打包DashOrderdt物件』，商品的商品區分有誤。"), 
  
  // ↓↓取得發票資訊

  DASH017001("執行『特別處理 發票資訊』，傳入值有誤，傳入的order是null。"),
  
  DASH017002("執行『特別處理 發票資訊』，傳入值有誤，傳入的orderNo或custNo是空值。"),

  DASH017003("執行『取得發票資訊』SQL，發生Exception。"),

  // ↓↓取得商品資訊

  DASH018001("執行『取得商品資訊』SQL，發生Exception。"),

  DASH018002("執行『取得商品資訊』，傳入值有誤，傳入的order是null。"),
  
  // ↓↓檢查商品現有庫存量

  DASH019001("執行『檢查商品現有庫存量』，商品總量不足。"),

  DASH019002("呼叫Tmax『取得商品總庫存數』，發生Exception。"),

  DASH019003("呼叫Tmax『取得商品款式庫存數』，發生Exception。"),

  DASH019004("呼叫Tmax『取得商品款式庫存數』，商品款式庫存量不足。"),
  
  DASH019005("呼叫moec『取得電子票券商品數量』，發生Exception。"),
  
  DASH019006("呼叫moec『取得電子票券商品數量』，回傳的rtn是null。"),
  
  DASH019007("呼叫moec『取得電子票券商品數量』，回傳的rtn.rtnCode不是200。"),
  
  DASH019008("呼叫moec『取得電子票券商品數量』，回傳的rtn.rtnCode不是數值。"),
  
  // ↓↓傳入參數轉成DashOrder物件

  DASH020001("執行『傳入參數轉成DashOrder物件』，傳入值有誤，傳入的order或cycle是null。"),

  DASH020002("執行『傳入參數轉成DashOrder物件』，傳入值有誤，傳入的params.getJSONObject()是null。"),

  DASH020003("執行『傳入參數轉成DashOrder物件』，傳入值有誤，傳入的pay(付款方式)有誤。"),

  DASH020004("執行『傳入參數轉成DashOrder物件』，傳入值有誤，傳入的qty小於等於0。"),

  DASH020005("執行『傳入參數轉成DashOrder物件』，傳入值有誤，傳入的goodsCode是空值。"),

  DASH020006("執行『傳入參數轉成DashOrder物件』，傳入值有誤，傳入的goodsdtCode是空值。"),

  DASH020007("執行『傳入參數轉成DashOrder物件』，傳入值有誤，傳入的promoNo長度大於20。"),

  DASH020008("執行『傳入參數轉成DashOrder物件』，商品總數量已超過購物車內商品最大承載量。"),

  // ↓↓清除佔量

  DASH021001("呼叫Tmax『清除佔量』，發生Exception。"),

  DASH021002("呼叫Tmax『清除佔量』，Tmax回傳的map是null。"),

  DASH021003("呼叫Tmax『清除佔量』，清除佔量失敗，Tmax回傳的F_SQLERRD2不是0。"),

  DASH021004("呼叫Tmax『清除佔量』，Tmax回傳的F_SQLERRD2不是數值。"),

  // ↓↓打包Orderreceipts

  DASH022001("執行『打包Orderreceipts』，傳入的pay.getSeq()有誤。"),

  DASH022002("呼叫Tmax『取得ATM的虛擬轉帳帳號』，發生Exception。"),

  DASH022003("呼叫Tmax『取得ATM的虛擬轉帳帳號』，取得的轉帳帳號是空值。"),

  DASH022004("付款方式為ATM，呼叫Tmax『取得繳款期限』，發生Exception。"),

  DASH022005("呼叫Tmax『取得繳款期限』，取得的ATM繳款期限日期格式有誤(yyyy/MM/dd HH:mm:ss)。"),

  DASH022006("付款方式為Alipay，呼叫Tmax『取得繳款期限』，發生Exception。"),
  
  DASH022007("呼叫Tmax『取得繳款期限』，取得的Alipay繳款期限日期格式有誤(yyyy/MM/dd HH:mm:ss)。"),

  DASH022008("付款方式為LinePay，呼叫Tmax『取得繳款期限』，發生Exception。"),

  DASH022009("呼叫Tmax『取得繳款期限』，取得的LinePay繳款期限日期格式有誤(yyyy/MM/dd HH:mm:ss)。"),
  
  DASH022010("執行『取得ibon 授權碼』SQL，回傳的ibonOrderNo有誤，ibonOrderNo是空值。"),
  
  DASH022011("執行ibon授權，回傳的map有誤，map是空值。"),
  
  DASH022012("執行ibon授權，回傳的STATUS有誤，STATUS不是字串S。"),
  
  DASH022013("執行ibon授權，回傳的PINCODE有誤，PINCODE是空值。"),
  
  DASH022014("執行ibon授權，發生Exception。"),
  
  DASH022015("執行ibon授權，回傳的DEADLINE有誤，DEADLINE是空值。"),

  // ↓↓檢查商品可否配送至商品收件POST(郵遞區號)

  DASH024001("執行『取得商品的不可配送區域』SQL，發生Exception。"),

  DASH024002("執行『取得商品的不可配送區域』SQL，取得的list是null。"),

  DASH024003("執行『取得可配送郵遞區號』SQL，發生Exception。"),

  DASH024004("執行『取得可配送郵遞區號』SQL，取得的list是null。"),

  DASH024005("執行『取得可配送郵遞區號』SQL，訂單內商品無法配送至該郵遞區號。"),

  DASH024006("執行『取得可配送郵遞區號』SQL，取得的list筆數有誤。"),

  DASH024007("執行『取得速達商品可配送郵遞區號』SQL，發生Exception。"),

  DASH024008("執行『取得速達商品可配送郵遞區號』SQL，取得的list是null。"),

  DASH024009("執行『取得速達商品可配送郵遞區號』SQL，訂單內商品無法配送至該郵遞區號。"),

  DASH024010("執行『取得速達商品可配送郵遞區號』SQL，取得的list筆數有誤。"),

  // ↓↓檢查發票可否配送至發票收件POST(郵遞區號)

  DASH025001("執行『取得可配送郵遞區號』SQL，發生Exception。"),

  DASH025002("執行『取得可配送郵遞區號』SQL，取得的list是null。"),

  DASH025003("執行『取得可配送郵遞區號』SQL，訂單發票無法配送至該郵遞區號。"),

  DASH025004("執行『取得可配送郵遞區號』SQL，取得的list筆數有誤。"),
 
  // ↓↓特別處理 信用卡資料

  DASH026001("執行『取得特定訂單所使用的信用卡資料，供此次訂單信用卡授權使用』，傳入值有誤，傳入的order是null。"),

  DASH026002("執行『取得特定訂單所使用的信用卡資料，供此次訂單信用卡授權使用』，付款方式有誤，付款方式不可為多種。"),

  DASH026003("執行『取得特定訂單所使用的信用卡資料，供此次訂單信用卡授權使用』，付款方式有誤，付款方式不是「信用卡一次付清」。"),

  DASH026004("執行『取得特定訂單所使用的信用卡資料，供此次訂單信用卡授權使用』，傳入值有誤，傳入的custNo或settleSeq是空值。"),

  DASH026005("執行『取得信用卡資訊』SQL，發生Exception。"),

  // ↓↓判斷商品屬於哪一台購物車

  DASH027001("執行『判斷商品屬於哪一台購物車』，傳入值有誤，傳入的order是null。"),

  DASH027002("執行『判斷商品屬於哪一台購物車』，此為車類.發票商品，目前尚未開放排程成立車類(發票)商品訂單。"),

  DASH027003("執行『判斷商品屬於哪一台購物車』，此為車類商品，但RECEIPT_FLAG是20(旅遊收據)。"),

  DASH027004("執行『判斷商品屬於哪一台購物車』，此為車類商品，但RECEIPT_FLAG是30(無憑證)。"),

  DASH027005("執行『判斷商品屬於哪一台購物車』，此為車類商品(汽機車/電動自行車)，限1單1品數量1。"),

  DASH027006("執行『判斷商品屬於哪一台購物車』，此為開店模式(02:玫瑰唱片g-music).發票商品，目前尚未開放排程成立開店模式(02:玫瑰唱片g-music).發票商品訂單。"),

  DASH027007("執行『判斷商品屬於哪一台購物車』，此為開店模式商品，但RECEIPT_FLAG是20(旅遊收據)。"),

  DASH027008("執行『判斷商品屬於哪一台購物車』，此為開店模式商品，但RECEIPT_FLAG是30(無憑證)。"),

  DASH027009("執行『判斷商品屬於哪一台購物車』，此為電子票券.發票商品，目前尚未開放排程成立電子票券(發票)商品訂單。"),

  DASH027010("執行『判斷商品屬於哪一台購物車』，此為電子票券.旅遊收據商品，目前尚未開放排程成立電子票券(旅遊收據)商品訂單。"),

  DASH027011("執行『判斷商品屬於哪一台購物車』，此為電子票券商品，但RECEIPT_FLAG是30(無憑證)。"),

  DASH027012("執行『判斷商品屬於哪一台購物車』，此為捷元軟體序號.發票商品，目前尚未開放排程成立捷元軟體序號(發票)商品訂單。"),

  DASH027013("執行『判斷商品屬於哪一台購物車』，此為捷元軟體序號商品，但RECEIPT_FLAG是20(旅遊收據)。"),

  DASH027014("執行『判斷商品屬於哪一台購物車』，此為捷元軟體序號商品，但RECEIPT_FLAG是30(無憑證)。"),

  DASH027015("執行『判斷商品屬於哪一台購物車』，此為贈品.旅遊收據商品，目前尚未開放排程成立贈品(旅遊收據)商品訂單。"),

  DASH027016("執行『判斷商品屬於哪一台購物車』，此為贈品.無憑證商品，目前尚未開放排程成立贈品(無憑證)商品訂單。"),

  DASH027017("執行『判斷商品屬於哪一台購物車』，此為速達.常溫.發票商品，目前尚未開放排程成立速達-常溫(發票)商品訂單。"),

  DASH027018("執行『判斷商品屬於哪一台購物車』，此為速達.冷凍.發票商品，目前尚未開放排程成立速達-冷凍(發票)商品訂單。"),

  DASH027019("執行『判斷商品屬於哪一台購物車』，此為速達.冷藏.發票商品，但RECEIPT_FLAG是30(無憑證)。"),

  DASH027020("執行『判斷商品屬於哪一台購物車』，此為速達.常溫.旅遊收據商品，目前尚未開放排程成立速達-常溫(旅遊收據)商品訂單。"),

  DASH027021("執行『判斷商品屬於哪一台購物車』，此為速達.冷凍.旅遊收據商品，目前尚未開放排程成立速達-冷凍(旅遊收據)商品訂單。"),

  DASH027022("執行『判斷商品屬於哪一台購物車』，此為速達.冷藏.旅遊收據商品，目前尚未開放排程成立速達-冷藏(旅遊收據)商品訂單。"),

  DASH027023("執行『判斷商品屬於哪一台購物車』，此為速達.常溫.無憑證商品，目前尚未開放排程成立速達-常溫(無憑證)商品訂單。"),

  DASH027024("執行『判斷商品屬於哪一台購物車』，此為速達.冷凍.無憑證商品，目前尚未開放排程成立速達-冷凍(無憑證)商品訂單。"),

  DASH027025("執行『判斷商品屬於哪一台購物車』，此為速達.冷藏.無憑證商品，目前尚未開放排程成立速達-冷藏(無憑證)商品訂單。"),
  
  DASH027026("執行『判斷商品屬於哪一台購物車』，此為宅配.旅遊收據商品，目前尚未開放排程成立宅配(旅遊收據)商品訂單。"),

  DASH027027("執行『判斷商品屬於哪一台購物車』，此為宅配.無憑證商品，目前尚未開放排程成立宅配(無憑證)商品訂單。"),
  
  DASH027028("執行『判斷商品屬於哪一台購物車』，判斷商品屬於哪一台購物車，商品的購物車不一致。"),
  
  DASH027029("執行『判斷商品屬於哪一台購物車』，此為開店模式(03:冷凍配送-鮮食家famicloud).發票商品，目前尚未開放排程成立開店模式(03:冷凍配送-鮮食家famicloud).發票商品訂單。"),
  
  DASH027030("執行『判斷商品屬於哪一台購物車』，此為開店模式.發票商品，目前尚未開放排程成立開店模式.發票商品訂單。"),

  // ↓↓檢查購物車結帳門檻限制

  DASH028001("執行『取得開店模式結帳門檻相關限制』SQL，取得的map.CODE_NAME有誤，TCODE的REMARK(門檻識別)是2(需加運費)，但是TCODE的CODE_NAME(運費品名)是空值。"),
  
  DASH028002("執行『取得開店模式結帳門檻相關限制』SQL，發生Exception。"),
  
  DASH028003("執行『取得開店模式結帳門檻相關限制』SQL，取得的map是null，無法取得開店模式結帳門檻相關限制。"),
  
  DASH028004("執行『取得開店模式結帳門檻相關限制』SQL，取得的map.REMARK有誤，TCODE的REMARK(門檻識別)不是1(不可結帳)或2(需加運費)。"),
  
  DASH028005("執行『取得開店模式結帳門檻相關限制』SQL，取得的map.REMARK1有誤，TCODE的REMARK1(門檻)不是數值。"),
  
  DASH028006("執行『檢查購物車結帳門檻限制』，購物車為開店模式，但商品的entpPattern是空值。"),
  
  DASH028007("執行『取得開店模式結帳門檻相關限制』SQL，取得的map.REMARK有誤，玫瑰唱片和鮮食家的REMARK(門檻識別)不是1(不可結帳)。"),
  
  DASH028008("執行『取得開店模式結帳門檻相關限制』SQL，購物車為開店模式(玫瑰唱片或鮮食家)，結帳金額未達門檻不可結帳。"),
  
  DASH028009("執行『取得開店模式結帳門檻相關限制』SQL，取得的map.REMARK2有誤，TCODE的REMARK(門檻識別)是2(需加運費)，但是TCODE的REMARK2(運費品號)是空值。"),

  // ↓↓信用卡授權
  
  DASH029001("執行『信用卡授權』，傳入值有誤，傳入的order是null。"),
  
  DASH029002("執行『信用卡授權』，發生Exception。"),
  
  DASH029003("執行『記錄信用卡授權資訊』，發生Exception。"),
  
  DASH029004("執行『信用卡授權』，信用卡授權失敗。"),
  
  DASH029005("執行『信用卡授權』，信用卡授權失敗。"),
  
  DASH029006("執行『信用卡授權』，傳入參數錯誤。"),
  
  DASH029007("執行『信用卡授權』，其他錯誤。"),
  
  DASH029008("執行『信用卡授權』，取SEQ_UB_CARD_ORDER失敗。"),
  
  DASH029009("執行『信用卡授權』，無法判斷是否使用新的Payment。"),
  
  DASH029010("執行『信用卡授權』，其他錯誤。"),
  
  // ↓↓處理ECM訂單行為行銷活動
  
  DASH030001("執行『取得ECM訂單行為行銷活動』SQL，發生Exception。"),
  
  DASH030002("執行『處理ECM訂單行為行銷活動主檔(17:訂單滿件滿額送贈品)』，cartName是空值，17:訂單滿件滿額送贈品的cartName不可以是空值。"),
  
  //↓↓檢查門檻並回傳是否符合門檻及是否為多門檻
  
  DASH031001("執行『取得ECM行銷活動的門檻』SQL，發生Exception。"),
  
  DASH031002("執行『檢查門檻並回傳是否符合門檻及是否為多門檻』，傳入值有誤，傳入的promoFlag不是1或2。"),
  
  DASH031003("執行『取得ECM行銷活動的門檻』SQL，取得的ecmPromoThresholdList是null。"),
  
  // ↓↓將ECM贈品加入購物車
  
  DASH032001("執行『取得ECM行銷活動優惠明細』SQL，發生Exception。"),
  
  DASH032002("執行『取得ECM行銷活動優惠明細』SQL，取得的preferList是null。"),

  DASH032003("執行『取得ECM行銷活動優惠明細』SQL，取得的preferType不等於5，或preferQty不大於0，或multiple不大於0。"),

  DASH032004("執行『取得商品資訊』SQL，發生Exception。"),

  DASH032005("執行『取得商品資訊』SQL，取得的goods是null。"),

  DASH032006("執行『將ECM贈品加入購物車』，贈品或主商品的發票區分有誤，贈品與主商品的發票區分必須都是10(發票)。"),

  DASH032007("執行『將ECM贈品加入購物車』，贈品溫層有誤，當主商品為乙配常溫時，贈品限制必須與主商品相同溫層。"),

  DASH032008("執行『將ECM贈品加入購物車』，供應商編號有誤，當主商品與贈品為甲配商品時，贈品限制必須與主商品相同供應商編號。"),

  DASH032009("執行『依品號查詢此商品的所有單品規格』SQL，發生Exception。"),

  DASH032010("執行『依品號查詢此商品的所有單品規格』SQL，取得的list是null。"),

  DASH032011("呼叫Tmax『取得商品款式庫存數』，發生Exception。"),

  DASH032012("呼叫moec『取得電子票券商品數量』，發生Exception。"),

  DASH032013("呼叫moec『取得電子票券商品數量』，回傳的rtn是null。"),
  
  DASH032014("呼叫moec『取得電子票券商品數量』，回傳的rtn.rtnCode不是200。"),
  
  DASH032015("呼叫moec『取得電子票券商品數量』，回傳的rtn.rtnCode不是數值。"),

  // ↓↓打包待處理訂單行為行銷活動的主商品
  
  DASH034001("執行『打包待處理行銷活動的主商品』，傳入值有誤，傳入的order是null。"),
  
  // ↓↓檢查DashOrder物件
  
  DASH035001("執行『檢查DashOrder物件』，傳入值有誤，傳入的order是null。"),
  
  DASH035002("執行『檢查DashOrder物件』，傳入值有誤，傳入的cart是null。"),
  
  //↓↓檢查取得的ECM訂單行為行銷活動主檔資料
  
  DASH036001("執行『檢查取得的ECM訂單行為行銷活動主檔資料』，傳入值有誤，傳入的ecmPromoM是null。"),
  
  DASH036002("執行『檢查取得的ECM訂單行為行銷活動主檔資料』，回傳值有誤，回傳的TF_EC_PROMO_M的PROMO_NO是空值。"),
  
  DASH036003("執行『檢查取得的ECM訂單行為行銷活動主檔資料』，回傳值有誤，回傳的TF_EC_PROMO_M的PROMO_NAME是空值。"),

  // ↓↓檢查取得的ECM行銷活動門檻明細檔資料
  
  DASH037001("執行『檢查取得的ECM行銷活動門檻明細檔資料』，回傳的TF_EC_PROMO_THRESHOLD.THRESHOLD_AMT有誤，門檻類型是1(滿額)，但THRESHOLD_AMT不大於0。"),
  
  DASH037002("執行『檢查取得的ECM行銷活動門檻明細檔資料』，回傳的TF_EC_PROMO_THRESHOLD.THRESHOLD_QTY有誤，門檻類型是2(滿件)，但THRESHOLD_QTY不大於0。"),
  
  DASH037003("執行『檢查取得的ECM行銷活動門檻明細檔資料』，回傳的TF_EC_PROMO_THRESHOLD.THRESHOLD_AMT或THRESHOLD_QTY有誤，門檻類型是3(滿額+滿件)，但THRESHOLD_AMT和THRESHOLD_QTY都不大於0。"),
  
  DASH037004("執行『檢查取得的ECM行銷活動門檻明細檔資料』，回傳的TF_EC_PROMO_THRESHOLD.THRESHOLD_TYPE有誤，門檻類型不是1(滿額)2(滿件)3(滿額+滿件)。"),

  // ↓↓週期配送傳入參數轉成DashOrder物件
  
  DASH038001("執行『週期配送傳入參數轉成DashOrder物件』，傳入值有誤，傳入的order或cycle是null。"),
  
  DASH038002("執行『週期配送傳入參數轉成DashOrder物件』，傳入值有誤，傳入的pay(付款方式)有誤。"),
  
  DASH038003("執行『週期配送傳入參數轉成DashOrder物件』，傳入值有誤，傳入的custNo或orderNo或receiverSeq或settleSeq是空值。"),

  DASH038004("執行『週期配送傳入參數轉成DashOrder物件』，商品總數量已超過購物車內商品最大承載量。"),

  // ↓↓檢查TfCycleGoodsdt
  
  DASH039001("執行『檢查TfCycleGoodsdt』，傳入值有誤，傳入的tfCycleGoodsdt是null。"),

  DASH039002("執行『檢查TfCycleGoodsdt』，傳入值有誤，傳入的tfCycleGoodsdt.getOrderQty()小於等於0。"),

  DASH039003("執行『檢查TfCycleGoodsdt』，傳入值有誤，傳入的tfCycleGoodsdt.getGoodsCode()是空值。"),

  DASH039004("執行『檢查TfCycleGoodsdt』，傳入值有誤，傳入的tfCycleGoodsdt.getGoodsdtCode()是空值。"),

  DASH039005("執行『檢查TfCycleGoodsdt』，傳入值有誤，傳入的tfCycleGoodsdt.getSalePrice()小於等於0。"),

  // ↓↓檢查DashGoods
  
  DASH040001("執行『檢查DashGoods』，傳入值有誤，傳入的goods是null。"),
  
  DASH040002("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getGoodsCode()是空值。"),
  
  DASH040003("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getMGroup()是空值。"),
  
  DASH040004("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getMGroup()是空值。"),
  
  DASH040005("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getDGroup()是空值。"),
  
  DASH040006("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getEntpCode()是空值。"),
  
  DASH040007("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getEntpCode()是空值。"),
  
  DASH040008("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getDelyType()不是10(乙配)或20(甲配)。"),
  
  DASH040009("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getWhCode()是空值。"),
  
  DASH040010("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getVatRate()不大於等於0。"),
  
  DASH040011("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSpeTaxYn()不是0或1。"),
  
  DASH040012("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getNorestAllotMonth()不大於等於0。"),
  
  DASH040013("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSignGb()不是80(結束)。"),
  
  DASH040014("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSqcGb()不是大於等於10且小於20。"),
  
  DASH040015("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSetYn()不是0或1。"),
  
  DASH040016("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSetYn()不是0，目前尚未開放排程成立SET商品訂單。"),
  
  DASH040017("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getGiftYn()不是0或1。"),
  
  DASH040018("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getStockChkPlace()不是1或2或3。"),
  
  DASH040019("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSaleGb()不是00(進行)。"),
  
  DASH040020("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getQtyAmtYn()不是0或1。"),
  
  DASH040021("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSetGoodsYn()不是0或1。"),
  
  DASH040022("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSetGoodsYn()是1，目前尚未開放排程成立組合商品(例如:任選、紅配綠)訂單。"),
  
  DASH040023("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getInternetYn()不是0或1。"),
  
  DASH040024("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getReceiptFlag()不是10(發票)或20(旅遊收據)或30(無憑證)。"),
  
  DASH040025("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getReceiptFlag()不是10(發票)，目前尚未開放排程成立不是10(發票)的訂單。"),
  
  DASH040026("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getCustFeedbackYn()不是0或1。"),
  
  DASH040027("執行『檢查DashGoods』，傳入值有誤，商品是贈品，但售價不等於0元。"),
  
  DASH040028("執行『檢查DashGoods』，傳入值有誤，商品不是贈品，但售價不大於0元。"),
  
  DASH040029("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSetDelyYn()不是0或1。"),
  
  DASH040030("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSetDelyGb()是空值。"),
  
  DASH040031("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getEntpPattern()是空值。"),
  
  DASH040032("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getDelyTemp()不是01(常溫)或02(冷凍)或03(冷藏)。"),
  
  DASH040033("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getEticketYn()不是0或1。"),
  
  DASH040034("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getLargeThingYn()不是0或1。"),
  
  DASH040035("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getEcSeqNoYn()不是0或1。"),
  
  DASH040036("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getFastShipping()不是0或1。"),
  
  DASH040037("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getSuperLargeThingYn()不是0或1。"),
  
  DASH040038("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getLargeMachineYn()不是0或1。"),
  
  DASH040039("執行『檢查DashGoods』，傳入值有誤，傳入的goods.getDiscMachYn()不是0或1。"),
  
  // ↓↓檢查goodsdt

  DASH041001("執行『檢查goodsdt』，傳入值有誤，傳入的map是null。"),
  
  DASH041002("執行『檢查goodsdt』，傳入值有誤，傳入的map.GOODSDT_INFO是空值。"),
  
  DASH041003("執行『檢查goodsdt』，傳入值有誤，傳入的map.SALE_GB不是00(進行)。"),
  
  // ↓↓檢查取得的TORDERDT(訂單細節)
  
  DASH042001("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt是null。"),
  
  DASH042002("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getOrderNo()是空值。"),
  
  DASH042003("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getOrderG()是空值。"),
  
  DASH042004("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getOrderD()是空值。"),
  
  DASH042005("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getOrderW()是空值。"),
  
  DASH042006("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getCustNo()是空值。"),
  
  DASH042007("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getReceiverSeq()是空值。"),
  
  DASH042008("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getGoodsGb()不是10(一般)20(SET)30(贈品)。"),
  
  DASH042009("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getGoodsGb()不是20(SET)，目前週期配商品 限只有一個子商品的SET品號。"),  
  DASH042010("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getGoodsCode()是空值。"),
  
  DASH042011("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getOrderQty()不大於0。"),
  
  DASH042012("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getSyscancel()小於0。"),
  
  DASH042013("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getSalePrice()小於等於0。"),
  
  DASH042014("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getPromoId()不是PR開頭的週期配送活動代碼。"),
  
  DASH042015("執行『檢查取得的TORDERDT(訂單細節)』，傳入值有誤，傳入的torderdt.getPromoSeq()是空值。"),
  
  // ↓↓檢查Tclaimdt

  DASH043001("執行『檢查Tclaimdt』，傳入值有誤，傳入的tclaimdt是null。"),
  
  DASH043002("執行『檢查Tclaimdt』，傳入值有誤，傳入的tclaimdt.getOrderNo()是空值。"),
  
  DASH043003("執行『檢查Tclaimdt』，傳入值有誤，傳入的tclaimdt.getOrderGSeq()是空值。"),
  
  DASH043004("執行『檢查Tclaimdt』，傳入值有誤，傳入的tclaimdt.getOrderDSeq()是空值。"),
  
  DASH043005("執行『檢查Tclaimdt』，傳入值有誤，傳入的tclaimdt.getOrderWSeq()是空值。"),
  
  DASH043006("執行『檢查Tclaimdt』，傳入值有誤，傳入的tclaimdt.getCustNo()是空值。"),
  
  DASH043007("執行『檢查Tclaimdt』，傳入值有誤，傳入的tclaimdt.getGoodsCode()是空值。"),
  
  DASH043008("執行『檢查Tclaimdt』，傳入值有誤，傳入的tclaimdt.getClaimGb()是空值。"),
  
  // ↓↓檢查取得的收據發票
  
  DASH044001("執行『檢查取得的收據發票』，傳入值有誤，傳入的treceiptreq是null。"),
  
  DASH044002("執行『檢查取得的收據發票』，傳入值有誤，傳入的treceiptreq.getReceiverSeq()是空值。"),
  
  DASH044003("執行『檢查取得的收據發票』，傳入值有誤，傳入的treceiptreq.getInvoiceType()不是1(個人)或2(法人)。"),
  
  DASH044004("執行『檢查取得的收據發票』，傳入值有誤，傳入的treceiptreq.getTrustYn()不是0或1。"),
  
  DASH044005("執行『檢查取得的收據發票』，傳入值有誤，傳入的treceiptreq.getDonateYn()不是0或1。"),
  
  DASH044006("執行『檢查取得的收據發票』，傳入值有誤，傳入的treceiptreq.getDonateYn()不是1(紙本銷折)或2(網路銷折)。"),
  
  DASH044007("執行『檢查取得的收據發票』，傳入值有誤，傳入的treceiptreq.getInvoiceType()是2(法人)，但treceiptreq.getCorpName()是空值。"),
  
  // ↓↓整理相同行銷活動的商品(15:滿件滿額送贈品)
  
  DASH045001("執行『整理相同行銷活動的商品(15:滿件滿額送贈品)』，整理後的promoMap.size是0。"),
  
  DASH045002("執行『取得ECM訂單行為行銷活動』SQL，發生Exception。"),
  
  // ↓↓檢查取得的TF_CYCLEM(週期配送主檔)資訊
  
  DASH046001("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的map是null。"),
  
  DASH046002("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的CYCLE_NO是空值。"),
  
  DASH046003("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的STATUS不是1(進行中)。"),
  
  DASH046004("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的CUST_NO是空值。"),
  
  DASH046005("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的ORDER_NO是空值。"),
  
  DASH046006("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的PROMO_SEQ是空值。"),

  DASH046007("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的GOODS_CODE是空值。"),
  
  DASH046008("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的SET_YN是0(非SET商品)，目前週期配商品限只有一個子商品的SET品號。"),
  
  DASH046009("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的FREQUENCY小於等於0。"),
  
  DASH046010("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的TIMES小於等於0。"),
  
  DASH046011("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的RECEIVER_SEQ是空值。"),
  
  DASH046012("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEM的SETTLE_SEQ是空值。"),
  
  DASH046013("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEDT的SEQ是空值。"),
  
  DASH046014("執行『檢查取得的TF_CYCLEM(週期配送主檔)資訊』，傳入值有誤，傳入的TF_CYCLEDT的EXPECT_DATE是空值。"),
  
  // ↓↓檢查取得的TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊
  
  DASH047001("執行『檢查取得的TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的tfCycleGoodsdt是null。"),
  
  DASH047002("執行『檢查取得的TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的TF_CYCLE_GOODSDT的CYCLE_NO是空值。"),
  
  DASH047003("執行『檢查取得的TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的TF_CYCLE_GOODSDT的ORDER_G_SEQ是空值。"),
  
  DASH047004("執行『檢查取得的TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的TF_CYCLE_GOODSDT的ORDER_D_SEQ是空值。"),
  
  DASH047005("執行『檢查取得的TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的TF_CYCLE_GOODSDT的GOODS_CODE是空值。"),
  
  DASH047006("執行『檢查取得的TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的TF_CYCLE_GOODSDT的GOODSDT_CODE是空值。"),
  
  DASH047007("執行『檢查取得的TF_CYCLE_GOODSDT(週期配送商品明細檔)資訊』，傳入值有誤，傳入的TF_CYCLE_GOODSDT的ORDER_QTY不大於0。"),
  
  // ↓↓檢查取得的購買人資料
  
  DASH048001("執行『檢查取得的購買人資料』，傳入值有誤，傳入的buyer是null。"),
  
  DASH048002("執行『檢查取得的購買人資料』，傳入值有誤，TMEMBER的MEMB_NO是空值。"),
  
  DASH048003("執行『檢查取得的購買人資料』，傳入值有誤，TMEMBER的WITHDRAWAL_YN不是0或1。"),
  
  DASH048004("執行『檢查取得的購買人資料』，傳入值有誤，TCUSTOMER的CUST_NAME是空值。"),
  
  DASH048005("執行『檢查取得的購買人資料』，傳入值有誤，TCUSTOMER的AGREE_YN不是1(未宣告)、Y(是)、N(否)。"),
  
  DASH048006("執行『檢查取得的購買人資料』，傳入值有誤，TRECEIVER的RECEIVER_SEQ是空值。"),
  
  DASH048007("執行『檢查取得的購買人資料』，傳入值有誤，TRECEIVER的RECEIVER_POST是空值。"),
  
  DASH048008("執行『檢查取得的購買人資料』，傳入值有誤，TRECEIVER的RECEIVER_POST_SEQ是空值。"),
  
  // ↓↓檢查取得的TF_CYCLEDT(週期配送明細檔)

  DASH049001("執行『檢查取得的TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，傳入的tfCycledt是null。"),
  
  DASH049002("執行『檢查取得的TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，TF_CYCLEDT的CYCLE_NO是空值。"),
  
  DASH049003("執行『檢查取得的TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，TF_CYCLEDT的SEQ是空值。"),
  
  DASH049004("執行『檢查取得的TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，TF_CYCLEDT的STATUS是空值。"),
  
  DASH049005("執行『檢查取得的TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，TF_CYCLEDT的EXPECT_DATE日期格式有誤(yyyy/MM/dd)。"),
  
  DASH049006("執行『檢查取得的TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，TF_CYCLEDT的STATUS是1(立單成功)，但TF_CYCLEDT的ORDER_NO是空值。"),

  DASH049007("執行『檢查取得的TF_CYCLEDT(週期配送明細檔)』，傳入值有誤，TF_CYCLEDT的STATUS是0(尚未立單)，但TF_CYCLEDT的ERROR_CODE不是空值。"),
  
  // ↓↓取得商品DT資訊

  DASH050001("執行『取得商品DT資訊』，傳入值有誤，傳入的order是null。"),

  DASH050002("執行『取得商品DT資訊』SQL，發生Exception。"),
  
  // ↓↓檢查付款方式

  DASH051001("執行『檢查付款方式』，QUEST_AMT有誤，QUEST_AMT不大於0元，或QUEST_AMT大於Integer.MAX_VALUE。"),

  DASH051002("執行『檢查付款方式』，付款方式有誤，目前排程立單尚未開放CARD(信用卡一次付清)。"),

  DASH051003("執行『檢查付款方式』，國外旅遊商品不可使用ATM付款，此訂單付款方式為ATM，但商品為國外旅遊商品。"),

  DASH051004("執行『檢查付款方式』，QUEST_AMT有誤，付款方式為ATM，但QUEST_AMT不大於0元，或QUEST_AMT不小於等於99999元。"),

  DASH051005("執行『檢查付款方式』，捷元軟體序號不可使用COD，此訂單付款方式為COD，但商品為捷元軟體序號。"),

  DASH051006("執行『檢查付款方式』，發票區分為20(旅遊收據)的商品不可使用COD，此訂單付款方式為COD，但商品的發票區分為20(旅遊收據)。"),

  DASH051007("執行『檢查付款方式』，付款方式有誤，COD(貨到付款)不可混付。"),

  DASH051008("執行『檢查付款方式』，配送方式為速達，付款方式為COD，QUEST_AMT超過COD上限10萬元。"),

  DASH051009("執行『檢查付款方式』，配送方式非速達，付款方式為COD，此為貴重品，QUEST_AMT超過COD上限50萬元。"),

  DASH051010("執行『檢查付款方式』，配送方式非速達，付款方式為COD，此非貴重品，QUEST_AMT超過COD上限10萬元。"),

  DASH051011("執行『檢查付款方式』，配送方式非速達，付款方式為COD，但訂單內有不可使用COD的商品。"),

  DASH051012("執行『檢查付款方式』，旅遊商品不可使用紅利金。"),

  DASH051013("呼叫Tmax『查詢客戶紅利金餘額及清單』，發生Exception。"),

  DASH051014("呼叫Tmax『查詢客戶紅利金餘額及清單』，取得的obj是null。"),

  DASH051015("呼叫Tmax『查詢客戶紅利金餘額及清單』，取得的usableSaveamt不是數值。"),

  DASH051016("執行『檢查付款方式』，此訂單使用的紅利金大於客戶的紅利金餘額。"),

  DASH051017("呼叫Tmax『查詢客戶暫收款餘額及清單』，發生Exception。"),

  DASH051018("呼叫Tmax『查詢客戶暫收款餘額及清單』，取得的list是null。"),

  DASH051019("呼叫Tmax『查詢客戶暫收款餘額及清單』，取得的usableDeposit不是數值。"),

  DASH051020("執行『檢查付款方式』，此訂單使用的暫收款大於客戶的暫收款餘額。"),
  
  DASH051021("執行『檢查付款方式』，付款方式有誤，GIFT(贈與)不可混付。"),

  DASH051022("執行『檢查付款方式』，QUEST_AMT有誤，付款方式為贈與，但QUEST_AMT不等於0元。"),

  DASH051023("執行『檢查付款方式』，QUEST_AMT有誤，付款方式為IBON，但QUEST_AMT不大於等於499元，或QUEST_AMT不小於等於19999元。"),

  DASH051024("執行『檢查付款方式』，付款方式有誤，目前排程立單尚未開放ALIPAY(支付寶)。"),

  DASH051025("執行『檢查付款方式』，付款方式有誤，目前排程立單尚未開放TWMPAY(台灣大哥大隨帳代收)。"),

  DASH051026("執行『檢查付款方式』，付款方式有誤，目前排程立單尚未開放LINEPAY(LinePay付款)。"),

  DASH051027("執行『檢查付款方式』，QUEST_AMT有誤，付款方式為非贈與，但QUEST_AMT不大於0元。"),
  
  // ↓↓檢查取得的信用卡資訊
  
  DASH052001("執行『檢查取得的信用卡資訊』，傳入值有誤，傳入的tcustsettle是null。★"),
  
  DASH052002("執行『檢查取得的信用卡資訊』，傳入值有誤，傳入的TCUSTSETTLE的SETTLE_GB不是01(信用卡)。"),
  
  DASH052003("執行『檢查取得的信用卡資訊』，傳入值有誤，傳入的TCUSTSETTLE的CARD_NO長度不足15碼。"),
  
  DASH052004("執行『檢查取得的信用卡資訊』，傳入值有誤，傳入的TCUSTSETTLE的VALID_DATE日期格式有誤(YYYYMM)。"),
  
  DASH052005("執行『檢查取得的信用卡資訊』，傳入值有誤，傳入的TCUSTSETTLE的VALID_DATE有誤，信用卡有效年月已過效期。"),

  // ↓↓處理共用商品行為行銷活動 (8:滿件滿額享折扣)
  
  DASH053001("執行『處理共用商品行為行銷活動 (8:滿件滿額享折扣) 』，整理後的promoMap.size是0。"),
  
  DASH053002("執行『處理共用商品行為行銷活動 (8:滿件滿額享折扣) 』SQL，發生Exception。"),
  
   // ↓↓計算ECM折扣 (8:滿件滿額享折扣)
  
  DASH054001("執行『取得ECM行銷活動優惠明細』SQL，發生Exception。"),
  
  DASH054002("執行『取得ECM行銷活動優惠明細』SQL，取得的preferList是null。"),

  // ↓↓新增收件人資訊失敗
 
  DASH055001("執行『新增收件人資訊失敗』。"),
  DASH055002("執行『新增收件人資訊失敗』，傳入值有誤，傳入的orderTelcellphone不為integer。"),
  DASH055003("執行『新增收件人資訊失敗』，傳入值有誤，傳入的orderTel不為integer。"),
 
  /**
   * 
   * <pre>
   * 
   * 需求單號: 2018061400056996
   * 需求主旨: 銀聯卡
   * 
   * </pre>
   */
  
  // ↓↓ 執行銀聯卡入款更新
  
  UP501001("執行銀聯卡入款更新，傳入值有誤，傳入的json.successFlag不是13(授權成功)或22(請款中)，不可執行銀聯卡入款更新。"),
  
  UP501002("執行銀聯卡入款更新，發生Exception。"),
  
  // ↓↓ 執行銀聯卡訂單取消
  
  UP502001("執行銀聯卡訂單取消，傳入值有誤，傳入的json.successFlag不是14(授權失敗)，不可執行銀聯卡訂單取消。"),

  UP502002("執行銀聯卡訂單取消，發生Exception。"),

  // ↓↓ 執行銀聯卡入款更新

  UP503001("執行銀聯卡入款更新，更新訂單付款結帳(TORDERRECEIPTS)，更新成功的筆數不等於1筆。"),

  UP503002("執行銀聯卡入款更新，新增訂單付款階段(TORDERRECEIPTSPROC)，新增成功的筆數不等於1筆。"),

  UP503003("執行銀聯卡入款更新，新增訂購階段資料檔(TORDERPROC)，新增成功的筆數不等於1筆。"),

  UP503004("執行銀聯卡入款更新，syslasts是空值。"),

  UP503005("執行銀聯卡入款更新，更新訂購庫存(TORDERSTOCK)，更新成功的筆數不等於1筆。"),  

  UP503006("執行銀聯卡入款更新，更新訂購庫存(TORDERSTOCK)，更新筆數有誤。"),

  UP503007("執行銀聯卡入款更新，goodsList是空值。"),

  UP503008("執行銀聯卡入款更新，更新訂單細節(TORDERDT)的預計到貨日(DELY_HOPE_DATE)，更新成功的筆數不等於1筆。"),

  UP503009("執行銀聯卡入款更新，更新訂單細節(TORDERDT)的進行階段(DO_FLAG)更新成功的筆數不大於1筆。"),

  // ↓↓ 執行銀聯卡訂單取消

  UP504001("呼叫Tmax的CLAIM_SAVE_I服務取消訂單失敗，回傳的HashMap是null。"),

  // ↓↓

  UP505001("檢查訂單付款階段(TORDERRECEIPTSPROC)資訊，無法取得訂單付款階段(TORDERRECEIPTSPROC)資訊。"),

  UP505002("檢查訂單付款階段(TORDERRECEIPTSPROC)資訊，TORDERRECEIPTSPROC.RECEIPT_SEQ是空值。"),

  // ↓↓

  UP506001("檢查訂購階段資料檔(TORDERPROC)資訊，無法取得訂購階段資料檔(TORDERPROC)資訊。"),

  UP506002("檢查訂購階段資料檔(TORDERPROC)資訊，TORDERPROC.ORDER_G_SEQ是空值。"),

  UP506003("檢查訂購階段資料檔(TORDERPROC)資訊，TORDERPROC.ORDER_D_SEQ是空值。"),

  UP506004("檢查訂購階段資料檔(TORDERPROC)資訊，TORDERPROC.ORDER_W_SEQ是空值。"),

  UP506005("檢查訂購階段資料檔(TORDERPROC)資訊，TORDERPROC.ORDER_P_SEQ是空值。"),

  UP506006("檢查訂購階段資料檔(TORDERPROC)資訊，List<Torderproc>是空值。"),

  // ↓↓

  UP507001("檢查訂單細節(TORDERDT)資訊，無法取得訂單細節(TORDERDT)資訊。"),

  UP507002("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_NO是空值。"),

  UP507003("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_G_SEQ是空值。"),

  UP507004("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_D_SEQ是空值。"),

  UP507005("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_W_SEQ是空值。"),

  UP507006("檢查訂單細節(TORDERDT)資訊，TORDERDT.CUST_NO是空值。"),

  UP507007("檢查訂單細節(TORDERDT)資訊，TORDERDT.RECEIVER_SEQ是空值。"),

  UP507008("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_GB是空值。"),

  UP507009("檢查訂單細節(TORDERDT)資訊，TORDERDT.GOODS_CODE是空值。"),

  UP507010("檢查訂單細節(TORDERDT)資訊，TORDERDT.GOODSDT_CODE是空值。"),

  UP507011("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_QTY小於等於0。"),

  UP507012("檢查訂單細節(TORDERDT)資訊，TORDERDT.SYSLAST小於等於0。"),

  UP507013("檢查訂單細節(TORDERDT)資訊，TORDERDT.DELY_TYPE是空值。"),

  UP507014("檢查訂單細節(TORDERDT)資訊，TORDERDT.DELY_GB是空值。"),

  UP507015("檢查訂單細節(TORDERDT)資訊，TORDERDT.DELY_HOPE_DATE是空值。"),

  UP507016("檢查訂單細節(TORDERDT)資訊，TORDERDT.GOODS_SELECT_NO是空值。"),

  UP507017("檢查訂單細節(TORDERDT)資訊，List<Torderdt>是空值。"),

  UP507018("檢查訂單細節(TORDERDT)資訊，TORDERDT.DO_FLAG不是10(接獲)。"),
  
  UP507019("檢查訂單細節(TORDERDT)資訊，TORDERDT.DO_FLAG不是10或20或22或32。"),
  
  UP507020("檢查訂單細節(TORDERDT)資訊，TORDERDT.DO_FLAG不是22或32，但TORDERDT.SYSLAST等於0。"),

  // ↓↓ 檢查配送地(TRECEIVER)資訊

  UP508001("檢查配送地(TRECEIVER)資訊，無法取得配送地(TRECEIVER)資訊。"),

  UP508002("檢查配送地(TRECEIVER)資訊，TRECEIVER.RECEIVER_SEQ是空值。"),

  UP508003("檢查配送地(TRECEIVER)資訊，TRECEIVER.RECEIVER_POST是空值。"),

  UP508004("檢查配送地(TRECEIVER)資訊，TRECEIVER.RECEIVER_POST_SEQ是空值。"),

  // ↓↓ 檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日

  UP509001("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，回傳的list是空值。"),

  UP509002("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，回傳的map是空值。"),

  UP509003("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TCOUNSEL_ORDER_G_SEQ是空值。"),

  UP509004("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TCOUNSEL_ORDER_D_SEQ是空值。"),

  UP509005("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TCOUNSEL_ORDER_W_SEQ是空值。"),

  UP509006("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TORDDT_DELY_HOPE_DATE是空值。"),

  UP509007("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TORDDT_DELY_HOPE_YN是空值。"),

  UP509008("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TORDDT_DELY_HOPE_TIME是空值。"),
  
  UP509009("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，重新計算的預定送貨日更新至torderdts的筆數有誤。"),

  // ↓↓ 檢查訂單細節(TORDERDT)資訊(訂單取消用)

  UP512001("檢查訂單細節(TORDERDT)資訊(訂單取消用)，回傳的list是空值。"),

  UP512002("檢查訂單細節(TORDERDT)資訊(訂單取消用)，無法取得訂單細節(TORDERDT)資訊。"),

  UP512003("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERM.INSERT_ID是空值。"),

  UP512004("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.ORDER_NO是空值。"),

  UP512005("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.ORDER_G_SEQ是空值。"),

  UP512006("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.ORDER_D_SEQ是空值。"),

  UP512007("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.ORDER_W_SEQ是空值。"),

  UP512008("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.SHOP_ID是空值。"),

  UP512009("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.CUST_NO是空值。"),

  UP512010("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.RECEIVER_SEQ是空值。"),

  UP512011("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.DO_FLAG不是10(接獲)。"),

  UP512012("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.GOODS_GB是空值。"),

  UP512013("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.MEDIA_GB是空值。"),

  UP512014("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.MEDIA_CODE是空值。"),

  UP512015("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.GOODS_CODE是空值。"),

  UP512016("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.GOODSDT_CODE是空值。"),

  UP512017("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.ORDER_QTY小於等於0。"),

  UP512018("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.SYSCANCEL不等於0。"),

  UP512019("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERDT.SYSLAST小於等於0。"),

  UP512020("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERGOODS.ORDER_QTY小於等於0。"),

  UP512021("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERGOODS.CANCEL_QTY不等於0。"),

  UP512022("檢查訂單細節(TORDERDT)資訊(訂單取消用)，TORDERGOODS.CLAIM_QTY不等於0。"),

  // ↓↓
  
  UP513001("執行銀聯卡請款成功但訂單已取消的資料異動，更新訂單付款結帳(TORDERRECEIPTS)，更新成功的筆數不等於1筆。"),
  
  UP513002("執行銀聯卡請款成功但訂單已取消的資料異動，新增請款TCARDREQ，新增成功的筆數不等於1筆。"),
  
  UP513003("執行銀聯卡請款成功但訂單已取消的資料異動，新增訂單付款階段(TORDERRECEIPTSPROC)，新增成功的筆數不等於1筆。"),
  
  // ↓↓ 因取消訂單，新增一筆TCARDLOG

  UP514001("因取消訂單，新增一筆TCARDLOG，發生Exception。"),

  UP514002("因取消訂單，新增一筆TCARDLOG，回傳的result是空值。"),

  UP514003("因取消訂單，新增一筆TCARDLOG，回傳的cardLogNo是空值。"),

  // ↓↓ 新增一筆TCARDLOG

  UP515001("新增一筆TCARDLOG，發生Exception。"),

  UP515002("新增一筆TCARDLOG，回傳的result是空值。"),

  UP515003("新增一筆TCARDLOG，回傳的cardLogNo是空值。"),
  
  // ↓↓ 檢查TCARDCODE資訊

  UP516001("檢查TCARDCODE資訊，無法取得TCARDCODE。"),

  // ↓↓ 執行銀聯卡請款成功資料異動
  
  UP517001("執行銀聯卡請款成功資料異動，更新訂單付款結帳(TORDERRECEIPTS)，更新成功的筆數不等於1筆。"),
  
  UP517002("執行銀聯卡請款成功資料異動，新增訂單付款階段(TORDERRECEIPTSPROC)，新增成功的筆數不等於1筆。"),
  
  UP517003("執行銀聯卡請款成功資料異動，新增請款TCARDREQ，新增成功的筆數不等於1筆。"),
  
  // ↓↓ 檢查PG銀聯交易通知的請求參數

  UP518001("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json是null。"),
  
  UP518002("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.domain是空值。"),

  UP518003("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.hubrrn是空值。"),

  UP518004("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.hubrrn字串長度大於15。"),

  UP518005("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.orderId是空值。"),

  UP518006("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.orderId字串長度大於19。"),
  
  UP518007("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.orderId字串長度小於3，從orderId韯取出來orderNo是空值。"),

  UP518008("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.cardNo字串長度大於20。"),

  UP518009("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.successFlag是空值。"),

  UP518010("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.successFlag不是數值。"),

  UP518011("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.transAmnt是空值。"),

  UP518012("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.transAmnt不是數值。"),

  UP518013("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.successFlag是14(授權失敗)，但json.responseCode是空值。"),

  UP518014("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.responseCode字串長度大於8。"),

  UP518015("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.successFlag是23(請款成功)或24(請款失敗)，但json.cutoffDate是空值。"),
  
  UP518016("檢查PG銀聯交易通知的請求參數，傳入值有誤，傳入的json.successFlag是23(請款成功)或24(請款失敗)，但json.cutoffDate日期格式有誤(yyyy/MM/dd HH:mm:ss)。"),
  
  // ↓↓ 執行銀聯卡請款成功資料異動
  
  UP519001("執行銀聯卡請款成功資料異動，傳入值有誤，傳入的json.successFlag不是23(請款成功)或24(請款失敗)，不可執行銀聯卡請款成功資料異動。"),
  
  UP519002("執行銀聯卡請款成功資料異動，先補執行銀聯卡入款更新，發生Exception。"),
  
  UP519003("執行銀聯卡請款成功資料異動，發生Exception。"),
    
  UP519004("執行銀聯卡請款成功但訂單已取消的資料異動，發生Exception。"),
  
  // ↓↓ 比對訂單付款結帳(TORDERRECEIPTS)資訊

  UP521001("執行取得訂單付款結帳(TORDERRECEIPTS)資訊SQL，發生Exception。"),

  UP521002("PG銀聯交易通知的請求參數orderId有誤，無法取得訂單付款結帳(TORDERRECEIPTS)資訊。"),

  UP521003("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.RECEIPT_NO是空值。"),

  UP521004("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.ORDER_NO是空值。"),

  UP521005("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.CUST_NO是空值。"),

  UP521006("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.DO_FLAG不是10(接獲)。"),
  
  UP521007("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.DO_FLAG不是10(接獲)，不需要繼續執行銀聯卡入款更新。"),

  UP521008("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.DO_FLAG不是10(接獲)或20(認可)。"),

  UP521009("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.DO_FLAG不是10(接獲)或20(認可)或30(請求)。"),
  
  UP521010("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.CARD_BANK_CODE是空值。"),

  UP521011("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.QUEST_AMT小於等於0。"),

  UP521012("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.QUEST_AMT與PG銀聯交易通知的請求參數transAmnt金額不符"),

  UP521013("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.VAN_COMP不是13(中國信託銀行(銀聯收單))。"),

  UP521014("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.CANCEL_YN不是0(否)或1(是)。"),

  UP521015("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.CANCEL_YN不是0(否)。"),
  
  UP521016("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.PG_HUBRRN是空值。"),

  UP521017("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.PG_HUBRRN與PG銀聯交易通知的請求參數hubrrn不符。"),  
  
  UP521018("比對訂單付款結帳(TORDERRECEIPTS)資訊，訂單已取消，但TORDERRECEIPTS.DO_FLAG不是22或32。"),
  
  UP521019("比對訂單付款結帳(TORDERRECEIPTS)資訊，訂單已取消，但TORDERRECEIPTS.DO_FLAG不是22或32。"),

  /**
   * 登記活動機制贈品立單排程訊息
   * @author zrtseng 2018.02.05
   */

  //act_type:14 行銷品號登記
  PMGOA014000("前個排程尚未執行完畢"),
  PMGOA014001("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，ltPromoMechGiftRedeem為null"),
  PMGOA014002("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，無需要立單的獎品兌換檔"),
  PMGOA014003("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，redeem_seq格式錯誤"),
  PMGOA014004("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，m_promo_no格式錯誤"),
  PMGOA014005("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，dt_promo_no格式錯誤"),
  PMGOA014006("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，cust_no格式錯誤"),
  PMGOA014007("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，insert_date格式錯誤"),
  PMGOA014008("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，order_status格式錯誤"),
  PMGOA014009("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，start_date格式錯誤"),
  PMGOA014010("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，end_date格式錯誤"),
  PMGOA014011("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，ord_yn格式錯誤"),
  PMGOA014012("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，ord_itv格式錯誤"),
  PMGOA014013("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，ord_cnt_type格式錯誤"),
  PMGOA014014("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，ord_num格式錯誤"),
  PMGOA014015("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，ord_amt格式錯誤"),
  PMGOA014016("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，cart_type格式錯誤"),
  PMGOA014017("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，ord_type格式錯誤"),
  PMGOA014018("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，m_promo_name格式錯誤"),
  PMGOA014019("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，m_insert_id格式錯誤"),
  PMGOA014020("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，ecm_promo_no格式錯誤"),
  PMGOA014021("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，gift_goods_code格式錯誤"),
  PMGOA014022("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，gift_goodsdt_code格式錯誤"),
  PMGOA014023("執行『act_type:14 行銷品號登記 設定可立單期限內的獎品兌換檔』，ltChkOrdPromoMechGiftRedeem為空值"),
  PMGOA014024("執行『act_type:14 行銷品號登記 檢查訂單資格』，ltChkOrdPromoMechGiftRedeem為空值"),
  PMGOA014025("執行『act_type:14 行銷品號登記 檢查訂單資格』，無符合訂單資格的獎品兌換檔清單"),
  PMGOA014026("執行『act_type:14 行銷品號登記 檢查訂單是否過鑑賞期』，ltQualifyPromoMechGiftRedeem為空值"),
  PMGOA014027("執行『act_type:14 行銷品號登記 更新獎品兌換檔立單狀態』，執行結果代碼為空值"),
  PMGOA014028("執行『act_type:14 行銷品號登記 更新獎品兌換檔立單狀態』，無訂單過鑑賞期的獎品兌換檔清單"),
  PMGOA014029("執行『act_type:14 行銷品號登記 更新獎品兌換檔立單狀態』，ltOverAPPromoMechGiftRedeem更新結果為空值"),
  PMGOA014030("執行『act_type:14 行銷品號登記 更新獎品兌換檔立單狀態』，ltMkOrdPromoMechGiftRedeem為空值"),
  PMGOA014031("執行『act_type:14 行銷品號登記 贈品立單』，ltMkOrdPromoMechGiftRedeem為空值"),
  PMGOA014032("執行『act_type:14 行銷品號登記 贈品立單』，立單發生失敗"),
  PMGOA014033("執行『act_type:14 行銷品號登記 復原立單失敗的獎品兌換檔立單狀態』，更新發生失敗"),

    /**
   * 
   * <pre>
   * 
   * 需求單號: 2018082400059379
   * 需求主旨: 信用卡3D驗證
   * 
   * </pre>
   */
  
  // 執行信用卡3D驗證成功訂單狀態更新
  
  DNM3D501001("執行PG信用卡3D驗證成功訂單狀態更新，傳入值有誤，傳入的json.successFlag不是AP(3D交易授權成功)，不可執行訂單狀態更新。"),

  DNM3D501002("執行PG信用卡3D驗證成功訂單狀態更新，發生Exception。"),

  DNM3D501003("執行PG信用卡3D驗證成功，判斷3D驗證結果欄位的值(SecureStatus)，發生Exception。"),

  DNM3D503001("執行PG信用卡3D驗證成功訂單狀態更新，更新訂單付款結帳(TORDERRECEIPTS)，更新成功的筆數不等於1筆。"),

  DNM3D503002("執行PG信用卡3D驗證成功訂單狀態更新，新增訂單付款階段(TORDERRECEIPTSPROC)，新增成功的筆數不等於1筆。"),

  DNM3D503003("執行PG信用卡3D驗證成功訂單狀態更新，新增訂購階段資料檔(TORDERPROC)，新增成功的筆數不等於1筆。"),

  DNM3D503004("執行PG信用卡3D驗證成功訂單狀態更新，準備訂購庫存(TORDERSTOCK)需要的參數(syslasts)是空值。"),

  DNM3D503005("執行PG信用卡3D驗證成功訂單狀態更新，更新訂購庫存(TORDERSTOCK)，更新成功的筆數不等於1筆。"),

  DNM3D503006("執行PG信用卡3D驗證成功訂單狀態更新，更新訂購庫存(TORDERSTOCK)，更新筆數有誤。"),

  DNM3D503007("執行PG信用卡3D驗證成功訂單狀態更新，goodsList是空值。"),

  DNM3D503008("執行PG信用卡3D驗證成功訂單狀態更新，更新訂單細節(TORDERDT)的預計到貨日(DELY_HOPE_DATE)，更新成功的筆數不等於1筆。"),

  DNM3D503009("執行PG信用卡3D驗證成功訂單狀態更新，更新訂單細節(TORDERDT)的進行階段(DO_FLAG)，更新成功的筆數不大於1筆。"),

  // 檢查PG信用卡3D驗證的請求參數

  DNM3D518001("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json是null。"),

  DNM3D518002("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.domain是空值。"),

  DNM3D518003("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.hubrrn是空值。"),

  DNM3D518004("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.hubrrn字串長度大於15。"),

  DNM3D518005("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.orderId是空值。"),

  DNM3D518006("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.orderId字串長度大於20。"),

  DNM3D518007("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.orderId字串長度小於3，從orderId擷取出來orderNo是空值。"),

  DNM3D518008("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.successFlag是空值。"),

  DNM3D518009("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.successFlag有非英文字的值。"),

  DNM3D518010("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.authAmnt是空值。"),

  DNM3D518011("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.authAmnt不是數值。"),

  DNM3D518012("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.successFlag是FA(授權失敗)，但json.errorMessage是空值。"),

  DNM3D518013("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.responseCode是空值。"),

  DNM3D518014("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.responseCode字串長度大於8。"),

  DNM3D518015("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.approveCode字串長度大於6。"),

  DNM3D518016("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.secureStatus字串長度大於1。"),

  DNM3D518017("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.transDate字串長度大於8(YYYYMMDD)。"),

  DNM3D518018("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.transTime字串長度大於6(HHMMSS)。"),

  DNM3D518019("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.deductPoint有值但不是數值。"),

  DNM3D518020("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.deductAmnt有值但不是數值。"),

  DNM3D518021("檢查PG信用卡3D驗證的請求參數，傳入值有誤，傳入的json.transType字串長度大於2。"),

  // 比對訂單付款結帳(TORDERRECEIPTS)資訊

  DNM3D521001("執行取得訂單付款結帳(TORDERRECEIPTS)資訊SQL，發生Exception。"),

  DNM3D521002("PG信用卡3D驗證的請求參數orderId有誤，無法取得訂單付款結帳(TORDERRECEIPTS)資訊。"),

  DNM3D521003("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.RECEIPT_NO是空值。"),

  DNM3D521004("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.ORDER_NO是空值。"),

  DNM3D521005("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.CUST_NO是空值。"),

  DNM3D521006("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.DO_FLAG不是10(接獲)。"),

  DNM3D521007("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.CARD_BANK_CODE是空值。"),

  DNM3D521008("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.QUEST_AMT小於等於0。"),

  DNM3D521009("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.QUEST_AMT與PG信用卡3D驗證的請求參數authAmnt金額不符。"),

  DNM3D521010("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.CANCEL_YN不是0(否)或1(是)。"),

  DNM3D521011("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.CANCEL_YN不是0(否)。"),

  DNM3D521012("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.PG_HUBRRN是空值。"),

  DNM3D521013("比對訂單付款結帳(TORDERRECEIPTS)資訊，TORDERRECEIPTS.PG_HUBRRN與PG信用卡3D驗證的請求參數hubrrn不符。"),

  // 檢查訂單付款階段(TORDERRECEIPTSPROC)資訊

  DNM3D505001("檢查訂單付款階段(TORDERRECEIPTSPROC)資訊，無法取得訂單付款階段(TORDERRECEIPTSPROC)資訊。"),

  DNM3D505002("檢查訂單付款階段(TORDERRECEIPTSPROC)資訊，TORDERRECEIPTSPROC.RECEIPT_SEQ是空值。"),

  // 檢查訂購階段資料檔(TORDERPROC)資訊

  DNM3D506001("檢查訂購階段資料檔(TORDERPROC)資訊，List<Torderproc>是空值。"),

  DNM3D506002("檢查訂購階段資料檔(TORDERPROC)資訊，無法取得訂購階段資料檔(TORDERPROC)資訊。"),

  DNM3D506003("檢查訂購階段資料檔(TORDERPROC)資訊，TORDERPROC.ORDER_G_SEQ是空值。"),

  DNM3D506004("檢查訂購階段資料檔(TORDERPROC)資訊，TORDERPROC.ORDER_D_SEQ是空值。"),

  DNM3D506005("檢查訂購階段資料檔(TORDERPROC)資訊，TORDERPROC.ORDER_W_SEQ是空值。"),

  DNM3D506006("檢查訂購階段資料檔(TORDERPROC)資訊，TORDERPROC.ORDER_P_SEQ是空值。"),

  // 檢查訂單細節(TORDERDT)資訊

  DNM3D507001("檢查訂單細節(TORDERDT)資訊，List<Torderdt>是空值。"),

  DNM3D507002("檢查訂單細節(TORDERDT)資訊，無法取得訂單細節(TORDERDT)資訊。"),

  DNM3D507003("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_NO是空值。"),

  DNM3D507004("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_G_SEQ是空值。"),

  DNM3D507005("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_D_SEQ是空值。"),

  DNM3D507006("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_W_SEQ是空值。"),

  DNM3D507007("檢查訂單細節(TORDERDT)資訊，TORDERDT.CUST_NO是空值。"),

  DNM3D507008("檢查訂單細節(TORDERDT)資訊，TORDERDT.RECEIVER_SEQ是空值。"),

  DNM3D507009("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_GB是空值。"),

  DNM3D507010("檢查訂單細節(TORDERDT)資訊，TORDERDT.DO_FLAG不是10(接獲)。"),

  DNM3D507011("檢查訂單細節(TORDERDT)資訊，TORDERDT.GOODS_CODE是空值。"),

  DNM3D507012("檢查訂單細節(TORDERDT)資訊，TORDERDT.GOODSDT_CODE是空值。"),

  DNM3D507013("檢查訂單細節(TORDERDT)資訊，TORDERDT.ORDER_QTY小於等於0。"),

  DNM3D507014("查訂單細節(TORDERDT)資訊，TORDERDT.SYSLAST小於等於0。"),

  DNM3D507015("檢查訂單細節(TORDERDT)資訊，TORDERDT.DELY_TYPE是空值。"),

  DNM3D507016("檢查訂單細節(TORDERDT)資訊，TORDERDT.DELY_GB是空值。"),

  DNM3D507017("檢查訂單細節(TORDERDT)資訊，TORDERDT.DELY_HOPE_DATE是空值。"),

  DNM3D507018("檢查訂單細節(TORDERDT)資訊，TORDERDT.GOODS_SELECT_NO是空值。"),

  // 檢查配送地(TRECEIVER)資訊

  DNM3D508001("檢查配送地(TRECEIVER)資訊，無法取得配送地(TRECEIVER)資訊。"),

  DNM3D508002("檢查配送地(TRECEIVER)資訊，TRECEIVER.RECEIVER_SEQ是空值。"),

  DNM3D508003("檢查配送地(TRECEIVER)資訊，TRECEIVER.RECEIVER_POST是空值。"),

  DNM3D508004("檢查配送地(TRECEIVER)資訊，TRECEIVER.RECEIVER_POST_SEQ是空值。"),

  // 檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日

  DNM3D509001("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，回傳的list是空值。"),

  DNM3D509002("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，回傳的map是空值。"),

  DNM3D509003("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TCOUNSEL_ORDER_G_SEQ是空值。"),

  DNM3D509004("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TCOUNSEL_ORDER_D_SEQ是空值。"),

  DNM3D509005("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TCOUNSEL_ORDER_W_SEQ是空值。"),

  DNM3D509006("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TORDDT_DELY_HOPE_DATE是空值。"),

  DNM3D509007("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TORDDT_DELY_HOPE_YN是空值。"),

  DNM3D509008("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，map.F_TORDDT_DELY_HOPE_TIME是空值。"),

  DNM3D509009("檢查Tmax的ORDER_STOCK_I服務重新計算的預定送貨日，重新計算的預定送貨日更新至torderdts的筆數有誤。"),

  // 檢查新增一筆TCARDLOG

  DNM3D515001("新增一筆TCARDLOG，發生Exception。"),

  DNM3D515002("新增一筆TCARDLOG，回傳的result是空值。"),

  DNM3D515003("新增一筆TCARDLOG，回傳的cardLogNo是空值。"),

  // 判斷3D驗證結果欄位的值(SecureStatus)

  DNM3D504001("執行PG信用卡3D驗證成功，secureStatus等於Y(成功)，新增TUMS，新增成功的筆數不等於1筆。"),

  DNM3D504002("執行PG信用卡3D驗證成功，secureStatus不等於Y(成功)，呼叫TMAX進風控，TAMX回傳的F_RESULT不等於1。"),

  DNM3D504003("執行PG信用卡3D驗證成功，secureStatus不等於Y(成功)，呼叫TMAX進風控，發生Exception。"),

  // 執行信用卡3D驗證失敗訂單狀態更新

  DNM3D502001("執行PG信用卡3D驗證失敗訂單狀態更新，傳入值有誤，傳入的json.successFlag不是FA(3D交易授權失敗)，不可執行訂單狀態更新。"),

  DNM3D502002("執行PG信用卡3D驗證失敗訂單狀態更新，發生Exception。"),

  DNM3D513001("執行PG信用卡3D驗證失敗訂單狀態更新，更新訂單付款結帳(TORDERRECEIPTS)，更新成功的筆數不等於1筆。"),

  // 因3D驗證失敗，新增一筆TCARDLOG

  DNM3D514001("因3D驗證失敗，新增一筆TCARDLOG，發生Exception。"),

  DNM3D514002("因3D驗證失敗，新增一筆TCARDLOG，回傳的result是空值。"),

  DNM3D514003("因3D驗證失敗，新增一筆TCARDLOG，回傳的cardLogNo是空值。"),

  // 檢查重新3D付款成功之相關欄位的請求參數

  DNM3D519001("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json是null。"),

  DNM3D519002("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.newHubrrn是空值。"),

  DNM3D519003("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.newHubrrn字串長度大於15。"),

  DNM3D519004("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.orderNo是空值。"),

  DNM3D519005("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.orderNo字串長度大於17。"),

  DNM3D519006("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.cardNo是空值"),

  DNM3D519007("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.cardNo字串長度大於20"),

  DNM3D519008("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.validDate是空值"),

  DNM3D519009("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.validDate字串長度大於6"),

  DNM3D519010("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.cardName字串長度大於20"),

  DNM3D519011("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.cardBankCode是空值"),

  DNM3D519012("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.cardBankCode字串長度大於3"),

  DNM3D519013("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.residentNo是空值"),

  DNM3D519014("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.residentNo字串長度大於13"),

  DNM3D519015("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverHp1是空值"),

  DNM3D519016("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverHp1字串長度大於4"),

  DNM3D519017("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverHp2是空值"),

  DNM3D519018("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverHp2字串長度大於4"),

  DNM3D519019("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverHp3是空值"),

  DNM3D519020("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverHp3字串長度大於4"),

  DNM3D519021("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverDdd是空值"),

  DNM3D519022("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverDdd字串長度大於4"),

  DNM3D519023("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverTel1是空值"),

  DNM3D519024("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverTel1字串長度大於4"),

  DNM3D519025("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverTel2是空值"),

  DNM3D519026("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverTel2字串長度大於4"),

  DNM3D519027("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverTel3字串長度大於6"),

  DNM3D519028("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.guName是空值"),

  DNM3D519029("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.guName字串長度大於20"),

  DNM3D519030("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.dongName是空值"),

  DNM3D519031("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.dongName字串長度大於60"),

  DNM3D519032("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverAddr是空值"),

  DNM3D519033("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.receiverAddr字串長度大於100"),

  DNM3D519034("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.payMonth是空值"),

  DNM3D519035("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.payMonth字串長度大於2"),

  DNM3D519036("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.cvv是空值"),

  DNM3D519037("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.cvv字串長度大於3"),

  DNM3D519038("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.custName是空值"),

  DNM3D519039("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.custName字串長度大於100"),

  DNM3D519040("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.birthday是空值"),

  DNM3D519041("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.birthday字串長度大於8"),

  DNM3D519042("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.oldHubrrn是空值。"),

  DNM3D519043("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.oldHubrrn字串長度大於15。"),

  DNM3D519044("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.domain是空值。"),

  DNM3D519045("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.addrPost是空值。"),

  DNM3D005046("檢查重新3D付款成功之相關欄位的請求參數，傳入值有誤，傳入的json.addrPost字串長度大於8。"),

  // 執行更新Payment新回傳的交易編號(pg_hubrrn)

  DNM3D615001("執行更新重新3D付款成功之相關欄位，查詢TORDERRECEIPTS.RECEIPT_NO發生錯誤。"),

  DNM3D615002("執行更新重新3D付款成功之相關欄位，更新訂單付款結帳(TORDERRECEIPTS)，更新成功的筆數不等於1筆。"),

  DNM3D615003("執行更新重新3D付款成功之相關欄位，新增紀錄持卡人與訂購人不同的訂單(TF_RISK_CARDOWNER)，新增成功的筆數不等於1筆。"),

  DNM3D615004("執行更新重新3D付款成功之相關欄位，更新紀錄持卡人與訂購人不同的訂單(TF_RISK_CARDOWNER)，更新成功的筆數不等於1筆。"),

  DNM3D615005("執行更新重新3D付款成功之相關欄位，刪除紀錄持卡人與訂購人不同的訂單(TF_RISK_CARDOWNER)，刪除成功的筆數大於1筆。"),

  DNM3D516001("執行更新重新3D付款成功之相關欄位，發生Exception。"),

  // 檢查取得3D驗證訂單付款結帳(TORDERRECEIPTS)資訊的請求參數

  DNM3D511001("檢查取得3D驗證訂單付款結帳(TORDERRECEIPTS)資訊的請求參數，傳入值有誤，傳入的json是null。"),

  DNM3D511002("檢查取得3D驗證訂單付款結帳(TORDERRECEIPTS)資訊的請求參數，傳入值有誤，傳入的json.domain是空值。"),

  DNM3D511003("檢查取得3D驗證訂單付款結帳(TORDERRECEIPTS)資訊的請求參數，傳入值有誤，傳入的json.orderNo是空值。"),

  DNM3D511004("檢查取得3D驗證訂單付款結帳(TORDERRECEIPTS)資訊的請求參數，傳入值有誤，傳入的json.orderNo字串長度大於17。"),

  DNM3D517001("執行取得3D驗證訂單付款結帳(TORDERRECEIPTS)資訊，發生Exception。"),

  DNM3D517002("執行取得3D驗證訂單付款結帳(TORDERRECEIPTS)資訊，取得的資料不等於1筆。"),

  // 檢查取得訂單細節(TORDERDT)資訊的請求參數

  DNM3D510001("檢查取得訂單細節(TORDERDT)資訊的請求參數，傳入值有誤，傳入的json是null。"),

  DNM3D510002("檢查取得訂單細節(TORDERDT)資訊的請求參數，傳入值有誤，傳入的json.domain是空值。"),

  DNM3D510003("檢查取得訂單細節(TORDERDT)資訊的請求參數，傳入值有誤，傳入的json.orderNo是空值。"),

  DNM3D510004("檢查取得訂單細節(TORDERDT)資訊的請求參數，傳入值有誤，傳入的json.orderNo字串長度大於17。"),

  DNM3D510005("檢查取得訂單細節(TORDERDT)資訊的請求參數，傳入值有誤，傳入的json.custNo是空值。"),

  DNM3D510006("檢查取得訂單細節(TORDERDT)資訊的請求參數，傳入值有誤，傳入的json.custNo字串長度大於12。"),

  DNM3D512001("執行取得訂單細節(TORDERDT)資訊，發生Exception。"),

  ;

  private String message;

  private Errors(String message) {
    this.message = this.name() + "：" + message;
  }

  public static String getMessage(String status) {
    String message = "";
    if ("1".equals(status)) {
      message = "OK。";
    } else {
      for (Errors enumObj : Errors.values()) {
        if (status.equals(enumObj.name())) {
          message = enumObj.message;
        }
      }
      message = "".equals(message) ? "NG。" : message;
    }

    return message;
  }
}