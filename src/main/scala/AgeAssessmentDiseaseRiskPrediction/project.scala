package AgeAssessmentDiseaseRiskPrediction

import scala.util.Random
import com.raquo.laminar.api.L.*
import com.raquo.airstream.core.Observer
import com.raquo.airstream.ownership.{DynamicSubscription, Owner, Subscription}
import com.raquo.ew.JsArray
import com.raquo.laminar.DomApi
import com.raquo.laminar.api.L
import com.raquo.laminar.inputs
import com.raquo.laminar.keys.{EventProcessor, EventProp, HtmlProp}
import com.raquo.laminar.modifiers.{Binder, EventListener, KeyUpdater}
import com.raquo.laminar.nodes.{ReactiveElement, ReactiveHtmlElement}
import com.raquo.laminar.tags
import org.scalajs.dom
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.stream.{ActorMaterializer, Materializer}
import akka.stream.scaladsl.{Sink, Source}
import com.raquo.airstream.eventbus.EventBus
import org.scalajs.dom.{FormData, HTMLInputElement, Headers, Request}

import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.scalajs.js.typedarray.{ArrayBuffer, TypedArrayBuffer}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future, Promise}
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.{ActorMaterializer, Materializer}
import japgolly.scalajs.react.vdom.all.headers

import scala.language.postfixOps




var fileInput: Var[String] = Var("")
var labelInput: Var[String] = Var("")
var nameInput: Var[String] = Var("")
var genderInput: Var[String] = Var("")

def renderDataTable(): Element = {
  table(
    thead(tr(th("label"), th("Name"), th("Gender"), th("CpgSite"), th("Action"))),
    tbody(
      tr(
        td(
          input(
            typ := "text",
            placeholder := "Enter label here",
            inContext { thisNode => onInput.mapTo(thisNode.ref.value) --> labelInput.writer }
          )
        ),
        td(
          input(
            typ := "text",
            placeholder := "Enter Name here",
            inContext { thisNode => onInput.mapTo(thisNode.ref.value) --> nameInput.writer }
          )
        ),
        td(
          input(
            typ := "text",
            placeholder := "Enter Gender here",
            inContext { thisNode => onInput.mapTo(thisNode.ref.value) --> genderInput.writer }
          )
        ),
        td(
          input(
            typ := "text",
            placeholder := "Enter file name",
            inContext { thisNode => onInput.mapTo(thisNode.ref.value) --> fileInput.writer }
          )
        ),
        td(
          button(
            "🗑️",
            onClick --> {
              (_: dom.MouseEvent) => resetItems()
            }
          )
        )
      )

    )
  )
}

def resetItems(): Unit = {
  fileInput.set("")
  labelInput.set("")
  nameInput.set("")
  genderInput.set("")
}


def predict(apiUrl: String, inputs: Map[String, String], resultContainer: Div): Unit = {
  val formData = new FormData()
  inputs.foreach { case (k,v) => formData.append(k,v) }

  dom.fetch(apiUrl, RequestInit(
      "POST",
      body = formData,
      headers = Map("Content-Type" -> "application/octet-stream")
    )).flatMap(response => response.text())
    .toFuture
    .foreach { result =>
      // Process the prediction result
      resultContainer.textContent = s"Prediction result: $result"
    }
}


def appElement(): Element = {

  val apiUrl = "http://localhost:8080/predict"

  val resultContainer = div()
  div(
    h1("Age Assessment and Disease Risk Prediction"),
    renderDataTable(),
    div(
      button(
        margin := "10px",
        "Submit", onClick --> { (_: dom.MouseEvent) =>
          val inputs = Map(
            "fileContent" -> fileInput.now(),
            "label" -> labelInput.now(),
            "name" -> nameInput.now(),
            "gender" -> genderInput.now()
          )
          predict(apiUrl, inputs, resultContainer)
        }
      ),
      button("Reset", onClick --> { (_: dom.MouseEvent) =>
        resetItems()
      })
    ),
    resultContainer
  )
}

object Project {
  def main(args: Array[String]): Unit = {
    val container = dom.document.getElementById("app")
    render(container, appElement())
  }
}

