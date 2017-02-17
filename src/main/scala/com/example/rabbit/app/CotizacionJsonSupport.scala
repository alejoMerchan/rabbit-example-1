package com.sura.trace.services.rabbitmq.mappers

import java.util.Date

import com.spingo.op_rabbit.PlayJsonSupport

import org.joda.time.DateTime
import play.api.libs.json._

/**
 * Created by abelmeos on 2017/02/15.
 */
object CotizacionJsonSupport {
  import PlayJsonSupport._

}

case class InformacionConfidencial (
                                     snConoceSolicitante:  Option[String],
                                     tiempoConocido:       Option[String],
                                     dsConoceSolicitante:  Option[String],
                                     snClienteSolicito:    Option[String],
                                     dsClienteSolicito:    Option[String]
                                     )

object InformacionConfidencial {

  implicit val InformacionConfidencial = Json.format[InformacionConfidencial]

}

case class InformacionAdicional (
                                  snDepositoProvisional:   Option[String],
                                  informacionConfidencial: Option[InformacionConfidencial]
                                  )

object InformacionAdicional {

  implicit val InformacionAdicional = Json.format[InformacionAdicional]

}


case class TipoDireccion(
                          id:          Option[String],
                          descripcion: Option[String],
                          codigoPais:  Option[Int]
                          )

object TipoDireccion {

  implicit val TipoDireccion = Json.format[TipoDireccion]


}

case class Direccion(
                      tipoDireccion:          Option[TipoDireccion],
                      direccion:              Option[String],
                      municipio:              Option[String],
                      numeroTelefono:         Option[String],
                      esCorrespondencia:      Option[String],
                      email:                  Option[String],
                      esEmailCorrespondencia: Option[String],
                      codigoDepartamento:     Option[String],
                      codigoPostal:           Option[String],
                      codigoDaneSura:         Option[String]
                      )

object Direccion{

  implicit val Direccion = Json.format[Direccion]


}

case class Ocupacion(
                      id:          String,
                      descripcion: Option[String]
                      )

object Ocupacion {

  implicit val Ocupacion = Json.format[Ocupacion]


}

case class TipoIdentificacion(
                               id:          String,
                               descripcion: Option[String],
                               tipoPersona: String,
                               codigoPais:  Int
                               )

object TipoIdentificacion {

  implicit val TipoIdentificacion = Json.format[TipoIdentificacion]


}

case class Identificacion(
                           numero: String,
                           tipo:   TipoIdentificacion
                           )

object Identificacion {

  implicit val Identificacion = Json.format[Identificacion]


}

case class Persona(
                    identificacion:  Identificacion,
                    primerNombre:    String,
                    segundoNombre:   Option[String],
                    primerApellido:  String,
                    segundoApellido: Option[String],
                    fechaNacimiento: Option[DateTime],
                    sexo:            Option[String],
                    ocupacion:       Option[Ocupacion],
                    nombreCompleto:  Option[String],
                    tipoPersona:     Option[String],
                    numeroCelular:   Option[String],
                    direcciones:     Option[List[Direccion]],
                    estadoCivil:     Option[String],
                    edad:            Option[Int]
                    )

object Persona {

  implicit val Persona = Json.format[Persona]


}

case class Tomador(
                    datosPersonales: Persona
                    )

object Tomador {

  implicit val Tomador = Json.format[Tomador]


}

case class EntidadFinanciadora(
                                id:          String,
                                descripcion: Option[String]
                                )

object EntidadFinanciadora {

  implicit val EntidadFinanciadora = Json.format[EntidadFinanciadora]

}

case class Financiacion(
                         isFinanciada: String,
                         numeroCuotas: Option[Int],
                         entidad: Option[EntidadFinanciadora]
                         )

object Financiacion {

  implicit val Financiacion = Json.format[Financiacion]

}

case class InformacionSeguro(
                              abonoInicialReserva: Double,
                              edadFinSeguro:       Int,
                              duracionPagos:       Int,
                              tipoCuota:           String,
                              crecimientoAnual:    Double,
                              duracionSeguro:      Int,
                              tipoDuracion:        String,
                              tipoDuracionPagos:   String
                              )

object InformacionSeguro {

  implicit val InformacionSeguro = Json.format[InformacionSeguro]

}

case class FondoAhorro(
                        tipoAhorro:       Option[String],
                        valorMensual:     Option[Int],
                        crecimientoAnual: Option[Double],
                        rendimientoAnual: Option[Double]
                        )


object FondoAhorro {

  implicit val FondoAhorro = Json.format[FondoAhorro]

}



case class DetalleCobertura(
                             cdGarantia:        String,
                             cdSubgarantia:     String,
                             nombre:            String,
                             valorAsegurado:    Double,
                             poSobremortalidad: Int,
                             poOcupacion:       Int,
                             precio:            Double
                             )

object DetalleCobertura {

  implicit val DetalleCobertura = Json.format[DetalleCobertura]

}


case class Parentesco(
                       id:          Option[String],
                       descripcion: String
                       )

object Parentesco {

  implicit val Parentesco = Json.format[Parentesco]


}


case class DatosMedicos(
                         peso:                Option[Double],
                         estatura:            Option[Double],
                         nivelEstres:         Option[Int],
                         hipertension:        Option[String],
                         historia:            Option[String],
                         diabetes:            Option[String],
                         snEPS:               Option[String],
                         snMedicinaPrepagada: Option[String],
                         snPolizaVida:        Option[String]
                         )

object DatosMedicos {

  implicit val DatosMedicos = Json.format[DatosMedicos]


}


case class Beneficiario(
                         tipoBeneficiario:    String,
                         parentesco:          Parentesco,
                         porcentaje:          Int,
                         esOneroso:           Boolean,
                         descripcion:         String,
                         requiereCertificado: Option[Boolean],
                         persona:             Option[Persona],
                         esLeasing:           Option[Boolean],
                         esFinanciado:        Option[Boolean]
                         )

object Beneficiario {

  implicit val Beneficiario = Json.format[Beneficiario]


}

case class Ciudad(
                   id:          String,
                   descripcion: Option[String])

object Ciudad {

  implicit val Ciudad = Json.format[Ciudad]

}

case class Prospecto(
                      dni:             Option[String],
                      codigoAsesor:    Option[String],
                      datosPersonales: Persona,
                      parentesco:      Option[Parentesco],
                      tipoTelefono:    Option[String],
                      ciudad:          Option[Ciudad],
                      datosMedicos:    Option[DatosMedicos]
                      )

object Prospecto {

  implicit val Prospecto = Json.format[Prospecto]

}

case class Enfermedad(
                       id:                Option[String],
                       descripcion:       String,
                       medico:            Option[String],
                       institucionMedica: Option[String],
                       fechaPrimConsulta: Option[Date],
                       fechaUltmConsulta: Option[Date]
                       )

object Enfermedad {

  implicit val Enfermedad = Json.format[Enfermedad]

}

case class EnfermedadFamiliar(
                               parentesco:        Parentesco,
                               enfermedad:        Enfermedad,
                               edadDiagnostico:   String,
                               causaMuerte:       String,
                               edadFallecimiento: String
                               )

object EnfermedadFamiliar {

  implicit val EnfermedadFamiliar = Json.format[EnfermedadFamiliar]

}


case class Deporte(
                    id:          String,
                    descripcion: String
                    )

object Deporte {
  implicit val Deporte = Json.format[Deporte]
}

case class Asegurado(
                      prospecto:       Prospecto,
                      empresa:         Option[String],
                      ingresosSalario: Option[Int]
                      )

object Asegurado {
  implicit val Asegurado = Json.format[Asegurado]

}

case class Citologia(
                      snPractCitologia:        Option[String],
                      snAlteracionesCitologia: Option[String],
                      snCitologiaAntigua:      Option[String]
                      )

object Citologia {

  implicit val Citologia = Json.format[Citologia]


}

case class DeclaracionAsegurabilidad(
                                      enfermedadesGenerales:   Option[List[Enfermedad]],
                                      enfermedadesAdicionales: Option[List[Enfermedad]],
                                      deportesExtremos:        Option[List[Deporte]],
                                      enfermedadesFamiliares:  Option[List[EnfermedadFamiliar]],
                                      citologia:               Option[Citologia],
                                      snConduceMoto:                  Option[String]

                                      )

object DeclaracionAsegurabilidad {

  implicit val DeclaracionAsegurabilidad = Json.format[DeclaracionAsegurabilidad]


}


case class Asesor(
                   codigo:           String,
                   nickname:         String,
                   descripcion:      String,
                   nombre:           String,
                   mail:             String,
                   codigoDelegacion: String
                   )

object Asesor {

  implicit val Asesor = Json.format[Asesor]


}

case class Intermediario(
                          asesor:          Asesor,
                          poParticipacion: Int,
                          snLider:         String
                          )

object Intermediario{
  implicit val Intermediario = Json.format[Intermediario]

}



case class DetallePoliza(
                          isAuxiliar:            Boolean,
                          tipoDuracion:          String,
                          duracionVigencia:      Int,
                          fechaDiligenciamiento: Option[Date],
                          oficinaRadicacion:     Option[String],
                          fechaFinVigencia:      Option[Date],
                          numeroSolicitud:       Option[String],
                          numeroPoliza:          Option[String],
                          fechaLlegadaCompania:  Option[Date],
                          fechaInicioVigencia:   Option[Date],
                          snPolizaElectronica:   Option[String],
                          cdDocDestinatario:     Option[String]
                          )

object DetallePoliza{

  implicit val DetallePoliza = Json.format[DetallePoliza]


}


case class Poliza(
                   infoPoliza:     DetallePoliza,
                   intermediacion: Option[List[Intermediario]]
                   )


object Poliza {

  implicit val Poliza = Json.format[Poliza]

}


case class RiesgoVida(
                       informacionSeguro:         InformacionSeguro,
                       asegurado:                 Option[Asegurado],
                       beneficiarios:             Option[List[Beneficiario]],
                       coberturas:                List[DetalleCobertura],
                       fondoAhorro:               Option[FondoAhorro],
                       declaracionAsegurabilidad: Option[DeclaracionAsegurabilidad]
                       )


object RiesgoVida {

  implicit val RiesgoVida = Json.format[RiesgoVida]


}

case class DetalleCuenta(
                          nmCuenta:         Option[String],
                          fechaVencimiento: Option[Date],
                          cdTipoCuenta:     Option[String],
                          cdBanco:          Option[String]
                          )

object DetalleCuenta {

  implicit val DetalleCuenta = Json.format[DetalleCuenta]


}

case class InformacionBaria(
                             cuentahabiente: Option[Prospecto],
                             detalleCuenta:  Option[DetalleCuenta]
                             )

object InformacionBaria {

  implicit val InformacionBaria = Json.format[InformacionBaria]


}


case class DetallePrimas(
                          index:          Int,
                          edad:           Int,
                          valorAsegurado: Double,
                          pago:           Double,
                          pagoAjustado:   Double
                          )

object DetallePrimas {

  implicit val DetallePrimas = Json.format[DetallePrimas]


}

case class DetalleReserva(
                           index:           Int,
                           reserva:         Double,
                           reservaAjustada: Double,
                           saldoInicial:    Double,
                           saldoFinal:      Double
                           )

object DetalleReserva {

  implicit val DetalleReserva = Json.format[DetalleReserva]

}

case class TarifaVida(
                       primas:   Option[List[DetallePrimas]],
                       reservas: Option[List[DetalleReserva]]
                       )

object TarifaVida {

  implicit val TarifaVida = Json.format[TarifaVida]


}

case class TarifaAnexo(
                        anexo:  Option[String],
                        tarifa: Option[Double]
                        )

object TarifaAnexo {

  implicit val TarifaAnexo = Json.format[TarifaAnexo]

}


case class DetalleTarifa(
                          calculoTarifaVida: Option[TarifaVida],
                          tarifasAnexos:     Option[List[TarifaAnexo]]
                          )

object DetalleTarifa {

  implicit val DetalleTarifa = Json.format[DetalleTarifa]


}

case class InformacionPagos(
                             anual:      Double,
                             semestral:  Double,
                             trimestral: Double,
                             mensual:    Double
                             )

object InformacionPagos {

  implicit val InformacionPagos = Json.format[InformacionPagos]

}

case class InfoTarifa(
                       tarifa: Option[DetalleTarifa],
                       pagos:  Option[InformacionPagos]
                       )

object InfoTarifa {

  implicit val InfoTarifa = Json.format[InfoTarifa]

}


case class Cotizacion(
                       tomador:              Tomador,
                       financiacion:         Option[Financiacion],
                       riesgo:               RiesgoVida,
                       poliza:               Option[Poliza],
                       infoBancaria:         Option[InformacionBaria],
                       propositoCotizacion:  Option[String],
                       numeroCotizacion:     Option[String],
                       estadoCotizacion:     Option[String],
                       estadoSolicitud:      Option[String],
                       codigoCanal:          Option[String],
                       formaPago:            Option[String],
                       tarifa:               InfoTarifa,
                       medioPago:            Option[String],
                       operacion:            Option[String],
                       suboperacion:         Option[String],
                       codigoAsesor:         String,
                       cdusuario:            Option[String],
                       fechaCotizacion:      Date,
                       ramo:                 String,
                       subramo:              String,
                       dniUsuario:           Option[String],
                       asesoriaVenta:        Option[String],
                       informacionAdicional: Option[InformacionAdicional]
                       )


object Cotizacion {

  implicit val cotizacionFormat : Format[Cotizacion] = new Format[Cotizacion]{

    override def reads(json:JsValue):JsResult[Cotizacion] = {
      println("json a tratar: " + json)
      JsSuccess(
        Cotizacion(tomador = (json \ "tomador").as[Tomador], financiacion = (json \ "financiacion").asOpt[Financiacion],
          riesgo = (json\ "riesgo").as[RiesgoVida], poliza = (json \ "poliza").asOpt[Poliza], infoBancaria = (json \ "infoBancaria").asOpt[InformacionBaria],
          propositoCotizacion = (json \ "porpositoCotizacion").asOpt[String], numeroCotizacion = (json \ "numeroCotizacion").asOpt[String],
          estadoCotizacion = (json \ "estadoCotizacion").asOpt[String], estadoSolicitud = (json \ "estadoSolicitud").asOpt[String],
          codigoCanal = (json \ "codigoCanal").asOpt[String], formaPago = (json\"formaPago").asOpt[String], tarifa = (json \ "tarifa").as[InfoTarifa],
          medioPago = (json \ "medioPago").asOpt[String], operacion = (json \ "operacion").asOpt[String], suboperacion = (json \ "suboperacion").asOpt[String],
          codigoAsesor = (json \ "codigoAsesor").as[String], cdusuario = (json \ "cdusuario").asOpt[String], fechaCotizacion = (json \ "fechaCotizacion").as[Date],
          ramo = (json \ "ramo").as[String], subramo = (json \ "subramo").as[String], dniUsuario = (json \ "dniUsuario").asOpt[String],
          asesoriaVenta = ( json \ "asesoriaVenta").asOpt[String], informacionAdicional = ( json \ "informacionAdicional").asOpt[InformacionAdicional]
        )
      )
    }

    override def writes(cotizacion:Cotizacion):JsValue = {

      Json.obj("tomador" -> cotizacion.tomador , "financiacion" -> cotizacion.financiacion, "riesgo" -> cotizacion.riesgo , "poliza" -> cotizacion.poliza ,
        "infoBancaria" -> cotizacion.infoBancaria, "propositoCotizacion" -> cotizacion.propositoCotizacion, "numeroCotizacion" -> cotizacion.numeroCotizacion,
        "estadoCotizacion" -> cotizacion.estadoCotizacion, "estadoSolicitud" -> cotizacion.estadoSolicitud, "codigoCanal" -> cotizacion.codigoCanal,
        "formaPago" -> cotizacion.formaPago, "tarifa" -> cotizacion.tarifa, "medioPago" -> cotizacion.medioPago, "operacion" -> cotizacion.operacion,
        "suboperacion" -> cotizacion.suboperacion, "codigoAsesor" -> cotizacion.codigoAsesor, "cdusuario" -> cotizacion.cdusuario, "fechaCotizacion"-> cotizacion.fechaCotizacion,
        "ramo" -> cotizacion.ramo, "subramo" -> cotizacion.subramo, "dniUsuario" -> cotizacion.dniUsuario, "asesoriaVenta" -> cotizacion.asesoriaVenta,
        "informacionAdicional" -> cotizacion.informacionAdicional )

    }

  }

}
