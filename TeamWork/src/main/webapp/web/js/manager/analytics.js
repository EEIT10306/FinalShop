var ana = [];
var product = [];

$(document).ready(function () {
  google.charts.load("current", { packages: ["calendar", "corechart"] });
  google.charts.setOnLoadCallback(drawChart);
  google.charts.setOnLoadCallback(drawChart2);

  $.ajax({
    type: "POST",
    url: "/TeamWork/Manager.getRequisition",
    success: function (response) {
      for (i = 0; i < response.length; i++) {
        ana[i] = [new Date(response[i].a_date), response[i].a_tap]
      }
    }
  });

  //  var fake = ["65", "98", "6", "77", "40", "47", "90", "66", "77", "41", "5", "31", "91", "26", "73", "93", "1", "80", "46", "81", "24", "25", "10", "18", "8", "34", "59", "93", "46", "42", "35", "31", "94", "80", "36", "25", "88", "95", "33", "97", "63", "95", "17", "11", "83", "64", "16", "17", "12", "46", "59", "96"]
  var fake = [46, 85, 77, 1, 79, 60, 27, 42, 88, 78, 90, 12, 56, 54, 83, 39, 51, 68, 73, 98, 58, 9, 12, 35, 27, 31, 32, 68, 15, 77, 22, 61, 90, 34, 75, 54, 79, 77, 3, 71, 84, 55, 61, 65, 3, 53, 10, 95, 45, 28, 54, 98]

  $.ajax({
    type: "POST",
    url: "/TeamWork/Manager.getProduct",
    success: function (response) {
      product[0] = ["類別", "銷售量"]
      for (i = 0; i < response.length; i++) {
        product[(i + 1)] = [response[i].p_name, fake[i]]
      }
    }
  });

  function drawChart() {
    var dataTable = new google.visualization.DataTable();
    dataTable.addColumn({ type: 'date', id: 'Date' });
    dataTable.addColumn({ type: 'number', id: 'Won/Loss' });
    dataTable.addRows(ana);
    var chart = new google.visualization.Calendar(document.getElementById('calendar_basic'));
    var options = {
      title: "網頁瀏覽次數",
      // height: 350,
      calendar: {
        yearLabel: {
          bold: true,
          italic: true
        }
      },
      colorAxis: { colors: ['#c7c7e2', '#acd6ff', '#a3d1d1', '#fff0ac', '#ff9797'] }
    };
    chart.draw(dataTable, options);
  }

  function drawChart2() {
    var data = google.visualization.arrayToDataTable(product);

    var options = {
      title: '11月份商品類別銷售比',
      pieHole: 0.4,
      slices: {
        19: { offset: 0.4 },
        10: { offset: 0.35 },
        8: { offset: 0.3 },
        1: { offset: 0.25 },
        14: { offset: 0.2 },
      },
    };

    var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
    chart.draw(data, options);
  }

  $(".card-header").click(function () {
    var now = $(this).attr("data-ana")
    if ($(this).parent().children(".card-body").hasClass("setIn")) {
      $(this).parent().children(".card-body").removeClass("setIn")
    } else {
      $(this).parent().children(".card-body").addClass("setIn")
    }
  })

})
