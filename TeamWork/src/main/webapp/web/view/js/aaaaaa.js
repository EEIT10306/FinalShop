RadarChart.defaultConfig.color = d3.scale.category20b();
RadarChart.defaultConfig.radius = 3;
RadarChart.defaultConfig.levels = 5;
RadarChart.defaultConfig.maxValue = 5;
RadarChart.defaultConfig.w = 400;
RadarChart.defaultConfig.h = 400;

var data = [
    {
        className: 'argentina',
        axes: [
            { axis: "許願", value: 1 },
            { axis: "購物", value: 4 },
            { axis: "開團", value: 3.5 },
            { axis: "完願", value: 5 },
            { axis: "販賣", value: 3.5 },
            { axis: "跟團", value: 4 }
        ]
    }
];

var chart = RadarChart.chart();
var cfg = chart.config(); // retrieve default config
var svg = d3.select('#six-chart').append('svg').attr('width', cfg.w + cfg.w + 50).attr('height', cfg.h + cfg.h / 6);
svg.append('g').classed('single', 1).datum(dataset()).call(chart);

function dataset() {
    return data.map(function (d) {
        return {
            className: d.className,
            axes: d.axes.map(function (axis) {
                return { axis: axis.axis, value: axis.value };
            })
        };
    });
}