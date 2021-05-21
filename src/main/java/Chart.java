import org.knowm.xchart.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Chart {

    public void pieChartPlot(Integer[] votes,String[] candidate,String title){
        PieChart chart = new PieChartBuilder().width(800).height(600).title(title).build();
        Color[] sliceColors = new Color[votes.length];
        //use to generate list of  random color.
        for(int i=0;i<votes.length;i++){
            sliceColors[i] = new Color((int) (Math.random( )*256), (int)(Math.random( )*256), (int)(Math.random( )*256));
        }

        chart.getStyler().setSeriesColors(sliceColors);
        for(int i=0; i<votes.length ; i++){
            chart.addSeries(candidate[i] ,votes[i]);
        }

        new SwingWrapper<PieChart>(chart).displayChart();
    }

}
