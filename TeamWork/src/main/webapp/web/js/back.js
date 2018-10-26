(function () {
  $('#menu-action').click(function () {
    $('.sidebar').toggleClass('active');
    $('.main').toggleClass('active');
    $(this).toggleClass('active');

    if ($('.sidebar').hasClass('active')) {
      $(this).find('i').addClass('fa-close');
      $(this).find('i').removeClass('fa-bars');
    } else {
      $(this).find('i').addClass('fa-bars');
      $(this).find('i').removeClass('fa-close');
    }
  });

  // Add hover feedback on menu
  $('#menu-action').click(function () {
    $('.sidebar').toggleClass('hovered');
  });
})();

/*chart======================================================================================================*/

var data = [
  {
    "rank": 1,
    "city": "新北市",
    "cata": "直轄市",
    "count": "3,990,211"
  },
  {
    "rank": 2,
    "city": "臺中市",
    "cata": "直轄市",
    "count": "2,797,223"
  },
  {
    "rank": 3,
    "city": "高雄市",
    "cata": "直轄市",
    "count": "2,773,093"
  },
  {
    "rank": 4,
    "city": "臺北市",
    "cata": "直轄市",
    "count": "2,672,092"
  },
  {
    "rank": 5,
    "city": "桃園市",
    "cata": "直轄市",
    "count": "2,211,127"
  },
  {
    "rank": 6,
    "city": "臺南市",
    "cata": "直轄市",
    "count": "1,884,327"
  },
  {
    "rank": 7,
    "city": "彰化縣",
    "cata": "縣",
    "count": "1,278,568"
  },
  {
    "rank": 8,
    "city": "屏東縣",
    "cata": "縣",
    "count": "827,599"
  },
  {
    "rank": 9,
    "city": "雲林縣",
    "cata": "縣",
    "count": "688,081"
  },
  {
    "rank": 10,
    "city": "新竹縣",
    "cata": "縣",
    "count": "555,604"
  },
  {
    "rank": 11,
    "city": "苗栗縣",
    "cata": "縣",
    "count": "550,386"
  },
  {
    "rank": 12,
    "city": "嘉義縣",
    "cata": "縣",
    "count": "508,372"
  },
  {
    "rank": 13,
    "city": "南投縣",
    "cata": "縣",
    "count": "498,425"
  },
  {
    "rank": 14,
    "city": "宜蘭縣",
    "cata": "縣",
    "count": "455,758"
  },
  {
    "rank": 15,
    "city": "新竹市",
    "cata": "市",
    "count": "443,969"
  },
  {
    "rank": 16,
    "city": "基隆市",
    "cata": "市",
    "count": "370,461"
  },
  {
    "rank": 17,
    "city": "花蓮縣",
    "cata": "縣",
    "count": "328,601"
  },
  {
    "rank": 18,
    "city": "嘉義市",
    "cata": "市",
    "count": "268,809"
  },
  {
    "rank": 19,
    "city": "臺東縣",
    "cata": "縣",
    "count": "219,489"
  },
  {
    "rank": 20,
    "city": "金門縣",
    "cata": "縣",
    "count": "138,026"
  },
  {
    "rank": 21,
    "city": "澎湖縣",
    "cata": "縣",
    "count": "103,976"
  },
  {
    "rank": 22,
    "city": "連江縣",
    "cata": "縣",
    "count": "13,074"
  }
]

data.forEach(d => {
  d.count = +d.count.split(",").join("") //清除原資料的逗點符號及轉為數字
})

var svg = d3.select(".chart1")
svg.attr("width", 960).attr("height", 540)

var scaleHeight = d3.scaleLinear()
  .domain([0, 4000000]) //實際數字的可能範圍
  .range([0, 400]) //轉換後希望的範圍
var scaleColor = d3.scaleLinear()
  .domain([0, 4000000]) //實際數字的可能範圍
  .range(["blue", "#fc993c"]) //轉換後顏色範圍
var groups = svg.selectAll("g.city") //帶有city class 的 g 元素
  .data(data) //綁定資料
  .enter() //進入到有資料但沒實際元素的區域
  .append("g") //新增元素，產生對應數量的g群組
groups.append("text") //在每個g元素中再新增一個text元素
  .text(d => d.city) //回傳city資料
  .attr("y", 520) //距離上方距離
  .attr("x", (d, i) => i * 100) //距離左方的距離

// groups.append("rect")
//       .attr("x",(d,i)=>i*100+10) //距離左方的距離
//       .attr("height",(d)=>scaleHeight(d.count)) //長條形高度對應到資料的"count"
//       .attr("y",(d)=>-scaleHeight(d.count)+500) //長條圖頂部離上方的距離
//       .attr("fill",(d)=>scaleColor(d.count))
//       .attr("width",30) //給長條形寬度

groups.append("circle")
  .attr("cx", (d, i) => i * 100 + 20) //圓心距離左方的距離
  .attr("cy", 400) //圓心距離上方的距離
  .attr("r", (d) => 0) //圓的半徑
  .attr("fill", (d) => scaleColor(d.count)) //svg上色
  .transition()
  .duration(1000)
  .delay((d, i) => i * 200)
  .attr("r", (d) => scaleHeight(d.count) / 10) //圓的半徑
  .attr("cy", 200) //圓心距離上方的距離

groups.append("text")
  .text(d => d.count)
  .attr("y", (d) => 480 - scaleHeight(d.count)) //距離上方距離(減掉長條圖高度)
  .attr("x", (d, i) => i * 100) //距離左方的距離
  .style("font-size", "13px") //更改css用style

var line = d3.line()
  .x((d, i) => i * 100) //距離左方的距離
  .y((d, i) => -d.count / 10000 + 500) //距離上方的距離
//新增折線圖
svg.append("path")
  .datum(data) //綁定資料，只有一個資料(datum，複數為data)
  .attr("d", line) //給路徑屬性資料
  .attr("fill", "none") //不要填色
  .attr("stroke", "black") //黑色線條






















/*chart2======================================================================================================*/


//建立svg繪圖區域
var svg = d3.select(".chart2")
  .style("width", "800px")
  .style("height", "540px")

// var arc = d3.arc()
//     .innerRadius(50)
//     .outerRadius(120)

// svg.append("path")
//    .datum({startAngle: 0,endAngle: Math.PI*1.5}) 
//    .attr("d", arc)
//    .style("fill", "orange")
//    .style("transform","translate(200px,200px)")

// var line = d3.line()
//              .x((d,i)=>i*100)
//              .y((d,i)=>Math.random()*100)
// svg.append("path")
//    .datum(d3.range(10))
//    .attr("d", line)
//    .attr("fill","none")
//    .style("stroke", "white")
//    .style("transform","translate(200px,200px)")


//讀入資料
var data = d3.csvParse(`Year,NTD/USD,JPY/USD,USD/GBP,HKD/USD
2010,31.642,87.78,1.5461,7.7692
2011,29.464,79.81,1.6036,7.784
2012,29.614,79.79,1.5853,7.7564
2013,29.77,97.60,1.5645,7.756`, function (d, i) {

    return {
      year: d['Year'],
      values: [
        {
          name: "NTD",
          value: d['NTD/USD']
        }, {
          name: "JPY",
          value: d['JPY/USD']
        }, {
          name: "GBP",
          value: d['USD/GBP']
        }, {
          name: "HKD",
          value: d['HKD/USD']
        }
      ]
    }
  })

//建立每一年的群組
console.log(data)
var groups = svg.selectAll("g.bargroup")
  .data(data)
  .enter().append("g")
  .attr("class", "bargroup")
  .style("transform", (d, i) => `translate(${i * 200 + 40}px,500px)`)

//建立年份的文字
groups.append("text").text(d => d.year)
  .attr("y", 30)
  .style("fill", "gray")
  .style("font-size", "30px")
  .style("font-weight", "bold")

//繪製底線
groups.append("line")
  .attr("x1", 0)
  .attr("x2", 150)
  .attr("y1", -20)
  .attr("y2", -20)
  .style("stroke", "#222")

//顏色處理的scale
let colorify = d3.scaleOrdinal()
  .range(d3.schemeCategory10)

//數值處理的scale

let xScale = d3.scaleLinear()
  .domain([0, 4])
  .range([0, 160])

let yScale = d3.scaleLinear()
  .domain([0, 40])
  .range([0, 120])

//繪製長條圖
var bars = groups.append("g").attr("class", "bars")
  .style("transform", "translateY(-70px)")

  .selectAll("rect.bar").data(d => d.values)
  .enter().append("rect")

  .attr("class", "bar")
  .attr("fill", (d, i) => colorify(i))

  .attr("x", (d, i) => xScale(i))
  .attr("width", 30)
  .attr("height", 0)
  .attr("data-name", d => d.name)

  .transition()
  .delay((d, i) => i * 500 + 500)
  .duration(2000)
  .ease(d3.easeElastic)
  .attr("y", (d, i) => -yScale(d.value))
  .attr("height", d => yScale(d.value))

// 

//幣別的文字
var typeTexts = groups.selectAll("g.label").data(d => d.values)
  .enter().append("g")

  .append("text")
  .style('fill', "#222")
  .style("opacity", 0)

  .text(d => d.name)

  .attr("x", (d, i) => xScale(i))
  .attr("y", -40)

  .transition()
  .delay((d, i) => i * 500)
  .duration(1000)
  .style("opacity", 0.6)

//y座標軸
let axisGroup = svg.append("g").attr("class", "axis")
  .style("transform", "translateY(430px)")
  .selectAll("line.axis")
  .data(d3.range(6).map(d => 20 * (d + 1)))
  .enter()

axisGroup.append("line")
  .attr("class", "axis")
  .attr("stroke", "#222")
  .attr("x1", 0)
  .attr("x2", 960)
  .attr("y1", (d, i) => -yScale(d))
  .attr("y2", (d, i) => -yScale(d))
  .attr("stroke-dasharray", "5 5")
  .style("opacity", 0.3)

axisGroup.append("text")
  .text(d => d)
  .attr("x", 0)
  .attr("y", (d, i) => -yScale(d) - 15)
  .attr("fill", "#222")
  .style("opacity", 0.5)


/*日曆期間選擇======================================================================================================*/
$(function () {
  var dateFormat = "mm/dd/yy",
    from = $("#from")
      .datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 2
      })
      .on("change", function () {
        to.datepicker("option", "minDate", getDate(this));
      }),
    to = $("#to").datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 2
    })
      .on("change", function () {
        from.datepicker("option", "maxDate", getDate(this));
      });

  function getDate(element) {
    var date;
    try {
      date = $.datepicker.parseDate(dateFormat, element.value);
    } catch (error) {
      date = null;
    }
    return date;
  }
});

