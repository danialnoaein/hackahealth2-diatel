//
//  SlideItem.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class SlideItem: UIView {

    @IBOutlet weak var imageContainer: UIImageView!
    @IBOutlet weak var titleText: UITextView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        imageContainer.layer.cornerRadius = imageContainer.frame.height / 2
    }
}
