//
//  Extentions.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//




import Foundation
import UIKit




// IMPORTANT: Replace the red string below with the new name you'll give to this app
let APP_NAME = "iPino"



// MAIN COLORS
let MAIN_COLOR = UIColor(red: 2/255, green: 82/255, blue: 94/255, alpha: 1.0) /* #02525e */
let MAIN_COLOR_LITERAL = #colorLiteral(red: 0.0078, green: 0.3216, blue: 0.3686, alpha: 1) /* #02525e */
let BLACK_COLOR = UIColor(red: 38/255, green: 45/255, blue: 52/255, alpha: 1)

// Removing spaces from string
extension String {
    func removingWhitespaces() -> String {
        return components(separatedBy: .whitespaces).joined()
    }
}


// HUD View extension
let hudView = UIView(frame: CGRect(x:0, y:0, width:140, height: 140))
let label = UILabel()
let indicatorView = UIActivityIndicatorView(frame: CGRect(x:0, y:0, width:100, height:100))
extension UIViewController {
    func showHUD(_ mess:String) {
        UIApplication.shared.beginIgnoringInteractionEvents()
        hudView.center = CGPoint(x: view.frame.size.width/2, y: view.frame.size.height/2)
        hudView.backgroundColor = MAIN_COLOR
        hudView.alpha = 1.0
        hudView.layer.cornerRadius = 8
        hudView.layer.borderWidth = 1
        hudView.layer.borderColor = #colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)
        hudView.alpha = 0.95
        indicatorView.center = CGPoint(x: hudView.frame.size.width/2, y: hudView.frame.size.height/2)
        indicatorView.activityIndicatorViewStyle = .white
        hudView.addSubview(indicatorView)
        indicatorView.startAnimating()
        view.addSubview(hudView)
        
        label.frame = CGRect(x: 0, y: 90, width: 120, height:20)
        label.font = UIFont(name: "Shabnam", size: 14)
        label.text = mess
        label.textAlignment = .center
        label.textColor = UIColor.white
        hudView.addSubview(label)
    }
    
    func hideHUD() {
        hudView.removeFromSuperview()
        label.removeFromSuperview()
        UIApplication.shared.endIgnoringInteractionEvents() 
    }
    
    func simpleAlert(_ mess:String) {
        let alert = UIAlertController(title: APP_NAME,
                                      message: mess, preferredStyle: .alert)
        let ok = UIAlertAction(title: "OK", style: .default, handler: { (action) -> Void in })
        alert.addAction(ok)
        present(alert, animated: true, completion: nil)
    }
}


//extention bottom border
extension UIView {
    func addTopBorderWithColor(color: UIColor, width: CGFloat) {
        let border = CALayer()
        border.backgroundColor = color.cgColor
        border.frame = CGRect(x: 0, y: 0, width: self.frame.size.width, height: width)
        self.layer.addSublayer(border)
    }
    
    func addRightBorderWithColor(color: UIColor, width: CGFloat) {
        let border = CALayer()
        border.backgroundColor = color.cgColor
        border.frame = CGRect(x: self.frame.size.width - width, y: 0, width: width, height: self.frame.size.height)
        self.layer.addSublayer(border)
    }
    
    func addBottomBorderWithColor(color: UIColor, width: CGFloat) {
        let border = CALayer()
        border.backgroundColor = color.cgColor
        border.frame = CGRect(x: 0, y: self.frame.size.height - width, width: UIScreen.main.bounds.size.width, height: width)
        self.layer.addSublayer(border)
    }
    
    func addLeftBorderWithColor(color: UIColor, width: CGFloat) {
        let border = CALayer()
        border.backgroundColor = color.cgColor
        border.frame = CGRect(x: 0, y: 0, width: width, height: self.frame.size.height)
        self.layer.addSublayer(border)
    }
    
    
    func roundandshadow(radiussize : CGFloat){
        layer.masksToBounds = false
        layer.cornerRadius = radiussize
        layer.shadowColor = UIColor.darkGray.cgColor
        layer.shadowOffset = CGSize(width: CGFloat(0), height: CGFloat(0))
        layer.shadowOpacity = 0.5
    }
    
    func setGradientBackground(colorTop: UIColor, colorBottom: UIColor) {
        let gradientLayer = CAGradientLayer()
        gradientLayer.colors = [colorBottom.cgColor, colorTop.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0)
        gradientLayer.endPoint = CGPoint(x: 1, y: 1)
        gradientLayer.locations = [0, 1]
        gradientLayer.frame = bounds
        
        layer.insertSublayer(gradientLayer, at: 0)
    }
}
//MARK: Extention For Changing Font UISearchbar
/**********************************************************/

extension UISearchBar {
    
    func change(textFont : UIFont?) {
        
        for view : UIView in (self.subviews[0]).subviews {
            
            if let textField = view as? UITextField {
                textField.font = textFont
            }
        }
    }
    
}






