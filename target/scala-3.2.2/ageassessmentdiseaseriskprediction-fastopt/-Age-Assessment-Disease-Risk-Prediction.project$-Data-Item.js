'use strict';
import * as $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6 from "./internal-3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.js";
/** @constructor */
function $c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem(id, label, price, count) {
  this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_id = null;
  this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_label = null;
  this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_price = 0.0;
  this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_count = 0;
  this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_id = id;
  this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_label = label;
  this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_price = price;
  this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_count = count
}
export { $c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem as $c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem };
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype = new $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$h_O();
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.constructor = $c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem;
/** @constructor */
function $h_LAgeAssessmentDiseaseRiskPrediction_project$DataItem() {
  /*<skip>*/
}
export { $h_LAgeAssessmentDiseaseRiskPrediction_project$DataItem as $h_LAgeAssessmentDiseaseRiskPrediction_project$DataItem };
$h_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype = $c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype;
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.productIterator__sc_Iterator = (function() {
  return new $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$c_s_Product$$anon$1(this)
});
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.hashCode__I = (function() {
  var acc = (-889275714);
  var hash = acc;
  var data = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$f_T__hashCode__I("DataItem");
  acc = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_Statics$().mix__I__I__I(hash, data);
  var hash$1 = acc;
  var x = this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_id;
  var data$1 = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_Statics$().anyHash__O__I(x);
  acc = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_Statics$().mix__I__I__I(hash$1, data$1);
  var hash$2 = acc;
  var x$1 = this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_label;
  var data$2 = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_Statics$().anyHash__O__I(x$1);
  acc = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_Statics$().mix__I__I__I(hash$2, data$2);
  var hash$3 = acc;
  var dv = this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_price;
  var data$3 = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_Statics$().doubleHash__D__I(dv);
  acc = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_Statics$().mix__I__I__I(hash$3, data$3);
  var hash$4 = acc;
  var data$4 = this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_count;
  acc = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_Statics$().mix__I__I__I(hash$4, data$4);
  var hash$5 = acc;
  return $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_Statics$().finalizeHash__I__I__I(hash$5, 4)
});
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.equals__O__Z = (function(x$0) {
  if ((this === x$0)) {
    return true
  } else if ((x$0 instanceof $c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem)) {
    var x$0$2 = $as_LAgeAssessmentDiseaseRiskPrediction_project$DataItem(x$0);
    if (((this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_price === $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$n(x$0$2).LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_price) && (this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_count === $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$n(x$0$2).LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_count))) {
      var x = this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_id;
      var x$2 = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$n(x$0$2).LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_id;
      if ((x === null)) {
        var $$x1 = (x$2 === null)
      } else {
        var this$1 = $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$n(x);
        var $$x1 = (this$1 === x$2)
      }
    } else {
      var $$x1 = false
    };
    if (($$x1 && (this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_label === $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$n(x$0$2).LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_label))) {
      $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$n(x$0$2);
      return true
    } else {
      return false
    }
  } else {
    return false
  }
});
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.toString__T = (function() {
  return $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$m_sr_ScalaRunTime$()._toString__s_Product__T(this)
});
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.productArity__I = (function() {
  return 4
});
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.productPrefix__T = (function() {
  return "DataItem"
});
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.productElement__I__O = (function(n) {
  switch (n) {
    case 0: {
      return this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_id;
      break
    }
    case 1: {
      return this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_label;
      break
    }
    case 2: {
      return this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_price;
      break
    }
    case 3: {
      return this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_count;
      break
    }
    default: {
      throw $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$ct_jl_IndexOutOfBoundsException__T__(new $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$c_jl_IndexOutOfBoundsException(), ("" + n))
    }
  }
});
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.fullPrice__D = (function() {
  return (this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_price * this.LAgeAssessmentDiseaseRiskPrediction_project$DataItem__f_count)
});
function $as_LAgeAssessmentDiseaseRiskPrediction_project$DataItem(obj) {
  return (((obj instanceof $c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem) || (obj === null)) ? obj : $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$throwClassCastException(obj, "AgeAssessmentDiseaseRiskPrediction.project$DataItem"))
}
export { $as_LAgeAssessmentDiseaseRiskPrediction_project$DataItem as $as_LAgeAssessmentDiseaseRiskPrediction_project$DataItem };
function $isArrayOf_LAgeAssessmentDiseaseRiskPrediction_project$DataItem(obj, depth) {
  return (!(!(((obj && obj.$classData) && (obj.$classData.arrayDepth === depth)) && obj.$classData.arrayBase.ancestors.LAgeAssessmentDiseaseRiskPrediction_project$DataItem)))
}
export { $isArrayOf_LAgeAssessmentDiseaseRiskPrediction_project$DataItem as $isArrayOf_LAgeAssessmentDiseaseRiskPrediction_project$DataItem };
function $asArrayOf_LAgeAssessmentDiseaseRiskPrediction_project$DataItem(obj, depth) {
  return (($isArrayOf_LAgeAssessmentDiseaseRiskPrediction_project$DataItem(obj, depth) || (obj === null)) ? obj : $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$throwArrayCastException(obj, "LAgeAssessmentDiseaseRiskPrediction.project$DataItem;", depth))
}
export { $asArrayOf_LAgeAssessmentDiseaseRiskPrediction_project$DataItem as $asArrayOf_LAgeAssessmentDiseaseRiskPrediction_project$DataItem };
var $d_LAgeAssessmentDiseaseRiskPrediction_project$DataItem = new $j_internal$002d3ebfae0cba70adf981029a0da5b1e4b5ab5d02c6.$TypeData().initClass({
  LAgeAssessmentDiseaseRiskPrediction_project$DataItem: 0
}, false, "AgeAssessmentDiseaseRiskPrediction.project$DataItem", {
  LAgeAssessmentDiseaseRiskPrediction_project$DataItem: 1,
  O: 1,
  s_Equals: 1,
  s_Product: 1,
  Ljava_io_Serializable: 1
});
export { $d_LAgeAssessmentDiseaseRiskPrediction_project$DataItem as $d_LAgeAssessmentDiseaseRiskPrediction_project$DataItem };
$c_LAgeAssessmentDiseaseRiskPrediction_project$DataItem.prototype.$classData = $d_LAgeAssessmentDiseaseRiskPrediction_project$DataItem;
//# sourceMappingURL=-Age-Assessment-Disease-Risk-Prediction.project$-Data-Item.js.map
