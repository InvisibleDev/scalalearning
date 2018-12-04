package chapter10

import java.beans._
import java.io._
import java.util

trait PropertyChangeSupportScala {
  private val propertyChangeSupportInstance = new PropertyChangeSupport()

  def addPropertyChangeListener(listener: PropertyChangeListener) =
    propertyChangeSupportInstance.addPropertyChangeListener(listener)

  def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener) =
    propertyChangeSupportInstance.addPropertyChangeListener(propertyName, listener)

  def removePropertyChangeListener(listener: PropertyChangeListener) =
    propertyChangeSupportInstance.removePropertyChangeListener(listener)

  def removePropertyChangeListener(propertyName: String, listener: PropertyChangeListener) =
    propertyChangeSupportInstance.removePropertyChangeListener(propertyName, listener)

  def getPropertyChangeListeners = propertyChangeSupportInstance.getPropertyChangeListeners()

  def getPropertyChangeListeners(propertyName: String) =
    propertyChangeSupportInstance.getPropertyChangeListeners(propertyName)

  def firePropertyChange(propertyName: String, oldValue: Any, newValue: Any) =
    propertyChangeSupportInstance.firePropertyChange(propertyName, oldValue, newValue)

  def firePropertyChange(propertyName: String, oldValue: Int, newValue: Int) =
    propertyChangeSupportInstance.firePropertyChange(propertyName, oldValue, newValue)

  def firePropertyChange(propertyName: String, oldValue: Boolean, newValue: Boolean) =
    propertyChangeSupportInstance.firePropertyChange(propertyName, oldValue, newValue)

  def firePropertyChange(event: PropertyChangeEvent) = propertyChangeSupportInstance.firePropertyChange(event)

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Any, newValue: Any) =
    propertyChangeSupportInstance.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Int, newValue: Int) =
    propertyChangeSupportInstance.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Boolean, newValue: Boolean) =
    propertyChangeSupportInstance.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)

  def hasListeners(propertyName: String) = propertyChangeSupportInstance.hasListeners(propertyName)
}

object PropertyChangeSupportScala {
  def fire(listeners: Array[PropertyChangeListener], event: PropertyChangeEvent) =
    for (listener <- listeners)
      listener.propertyChange(event)
}