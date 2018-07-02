package org.me.Estatistica;
  
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
  
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
  
@ManagedBean(name="GraficoAreaMB")
public class GraficoArea implements Serializable {
  
    private LineChartModel areaModel;
  
    @PostConstruct
    public void init() {
        createAreaModel();
    }
  
    public LineChartModel getAreaModel() {
        return areaModel;
    }
      
    private void createAreaModel() {
        areaModel = new LineChartModel();
  
        LineChartSeries reservatorio1 = new LineChartSeries();
        reservatorio1.setFill(true);
        reservatorio1.setLabel("Despesas");
        reservatorio1.set("01/18", 23);
        reservatorio1.set("02/18", 38);
        reservatorio1.set("03/18", 44);
        reservatorio1.set("04/18", 40);
        reservatorio1.set("05/18", 47);        
        reservatorio1.set("06/18", 40);
        reservatorio1.set("07/18", 45);
  
        LineChartSeries reservatorio2 = new LineChartSeries();
        reservatorio2.setFill(true);
        reservatorio2.setLabel("Faturamento");
        reservatorio2.set("01/18", 43);
        reservatorio2.set("02/18", 38);
        reservatorio2.set("03/18", 64);
        reservatorio2.set("04/18", 50);
        reservatorio2.set("05/18", 27);        
        reservatorio2.set("06/18", 70);
        reservatorio2.set("07/18", 65);
         
        LineChartSeries reservatorio3 = new LineChartSeries();
        reservatorio3.setFill(true);
        reservatorio3.setLabel("Meta");
        reservatorio3.set("01/18", 73);
        reservatorio3.set("02/18", 88);
        reservatorio3.set("03/18", 94);
        reservatorio3.set("04/18", 80);
        reservatorio3.set("05/18", 77);        
        reservatorio3.set("06/18", 80);
        reservatorio3.set("07/18", 105);
  
        areaModel.addSeries(reservatorio1);
        areaModel.addSeries(reservatorio2);
        areaModel.addSeries(reservatorio3);
          
        areaModel.setTitle("Despesas X Faturamento x Metas");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);
          
        Axis xAxis = new CategoryAxis("Movimento por mes");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nível");
        yAxis.setMin(0);
        yAxis.setMax(500);
    }
      
}
