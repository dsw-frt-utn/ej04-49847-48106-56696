package views;

import data.Persistencia;
import domain.Marca;
import domain.Sucursal;
import domain.Vehiculo;
import domain.VehiculoTipo;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class Controlador {
    
    public static ArrayList<VehiculoViewModel> getVehiculos(){
        
      
        ArrayList<VehiculoViewModel> vehiculos = new ArrayList<>();
        for(Vehiculo vehiculo : Persistencia.getVehiculos()) {
            vehiculos.add(new VehiculoViewModel(vehiculo));
        }
        return vehiculos;
    }
    
    public static void setVehiculos(String patente, String marca, String modelo, int anio, double capcarga,String sucursal,String tipo, double kwBase,double kmLitros, double kmExtra)
    {
        Marca m = new Marca();
        Sucursal s =  new Sucursal();
        
        for(Marca marcas : Persistencia.getMarca())
        {
            if (marca.equals(marcas.getDescripcion()))
            {
               m = marcas;
            }
        }
        for (Sucursal sucursales : Persistencia.getSucursal())
        {
            if(sucursal.equals(sucursales.getCodigo()))
            {
                s = sucursales;
            }
        }
            
        
        if(tipo.equals(VehiculoTipo.COMBUSTIBLE.toString()))
        {
            Persistencia.setVehiculoCombustible(patente, m, modelo, anio, capcarga, s, kmLitros, kmExtra);
        }
        
        if(tipo.equals(VehiculoTipo.ELECTRICO.toString()))
        {
            Persistencia.setVehiculoElectricos(patente, m, modelo, anio, capcarga, s, kwBase);
        }
    }
    
       
    public static double[] calcularConsumos(Map<String, Double> vehiculos){
        double consumoElectricos = 0;
        double consumoCombustible= 0;
        for(Map.Entry<String, Double> entry : vehiculos.entrySet()){
           double consumo = 0;
           Optional<Vehiculo> vehiculo = Persistencia.getVehiculo(entry.getKey());
           if(vehiculo.isPresent()){
               consumo = vehiculo.get().calcularConsumo(entry.getValue());
               consumoElectricos += vehiculo.get().esDe(VehiculoTipo.ELECTRICO) ? consumo : 0;
               consumoCombustible += vehiculo.get().esDe(VehiculoTipo.COMBUSTIBLE) ? consumo : 0;
           }
        }
        return new double[] {consumoElectricos, consumoCombustible};
    }
    
    
    public static ArrayList<Marca> getMarcas()
    {
        ArrayList<Marca> marcas = new ArrayList<>();
        
        for(Marca marca : Persistencia.getMarca())
        {
            marcas.add(marca);
        }
        return marcas;
    }
    
    public static ArrayList<Sucursal> getSucursales()
    {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        for (Sucursal sucursal : Persistencia.getSucursal())
        {
            sucursales.add(sucursal);
        }
        return sucursales;
    }
    

    

    
}
