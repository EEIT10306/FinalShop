$(document).ready(function () {
  google.charts.load("current", { packages: ["calendar"] });
  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {
    var dataTable = new google.visualization.DataTable();
    dataTable.addColumn({ type: 'date', id: 'Date' });
    dataTable.addColumn({ type: 'number', id: 'Won/Loss' });
    dataTable.addRows([
      [new Date(2017, 3, 13), 12],
      [new Date(2017, 3, 14), 38024],
      [new Date(2017, 3, 15), 38024],
      [new Date(2017, 3, 16), 38108],
      [new Date(2017, 3, 17), 38229],
      // Many rows omitted for brevity.
      [new Date(2018, 9, 4), 38177],
      [new Date(2018, 9, 5), 38705],
      [new Date(2018, 9, 12), 38210],
      [new Date(2018, 9, 13), 38029],
      [new Date(2018, 9, 19), 38823],
      [new Date(2018, 9, 23), 38345],
      [new Date(2018, 9, 24), 38436],
      [new Date(2018, 9, 30), 38447]
    ]);

    var chart = new google.visualization.Calendar(document.getElementById('calendar_basic'));

    var options = {
      title: "日銷售量報表",
      // height: 350,
    };

    $(".card-header").click(function () {
      $(this).parent().children("#calendar_basic").html("")
      $(this).parent().children(".card-body").toggle()
      chart.draw(dataTable, options);
    })
  }

  //-----------------------------
})
